//memory dfs
class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[K+1][N][N];
        for (int i = 0; i <= K; i++) 
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    dp[i][j][k] = -1.0;
        return helper(dp, N, K, r, c);
    }
    
    private double helper(double[][][] dp, int N, int k, int r, int c) {
        // if out of board, return 0.0
        if (r < 0 || r >= N || c < 0 || c >= N) return 0.0;
        // when k = 0, no more move, so it's 100% safe
        if (k == 0) return 1.0;
        if (dp[k][r][c] != -1.0) 
            return dp[k][r][c];
        double ans = 0.0;
        ans += helper(dp, N, k-1, r-1, c-2)/8;
        ans += helper(dp, N, k-1, r-1, c+2)/8;        
        ans += helper(dp, N, k-1, r-2, c-1)/8;
        ans += helper(dp, N, k-1, r-2, c+1)/8;
        ans += helper(dp, N, k-1, r+1, c-2)/8;        
        ans += helper(dp, N, k-1, r+1, c+2)/8;
        ans += helper(dp, N, k-1, r+2, c-1)/8;
        ans += helper(dp, N, k-1, r+2, c+1)/8;        
        dp[k][r][c] = ans;
        return ans; 
    }
}