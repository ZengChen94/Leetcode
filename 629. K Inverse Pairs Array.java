public class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int M = 1000000007;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k && j <= i * (i - 1) / 2; j++) {
                if (i == 1 && j == 0) {
                    dp[i][j] = 1;
                    break;
                } else if (j == 0)
                    dp[i][j] = 1;
                else {
                    int val = (dp[i - 1][j] + M - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % M;
                    dp[i][j] = (dp[i][j - 1] + val) % M;
                }
            }
        }
        return dp[n][k];
    }
}

//TLE
public class Solution {
    int M = 1000000007;
    
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 1;
        }
        helper(n, k, dp);
        return dp[n][k]%M;
    }
    
    public int helper(int n, int k, int[][] dp) {
        int cnt = 0;
        for (int i = 0; i <= (n-1) && i <= k; i++) {
            if (dp[n-1][k-i] != 0) {
                cnt += dp[n-1][k-i];
                cnt %= M;
            }
            else {
                cnt += helper(n-1, k-i, dp);
                cnt %= M;
            }
        }
        dp[n][k] = cnt;
        return dp[n][k];
    }
}

//WA
public class Solution {
    int M = 1000000007;
    
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < k+1; j++) {
                if (j >= i-1)
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j] - dp[i-1][j-(i-1)])%M;
                else
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j])%M;
            }
        }
        return dp[n][k]%M;
    }
}