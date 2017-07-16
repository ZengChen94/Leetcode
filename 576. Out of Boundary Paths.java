public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] map = new int[m][n][N+1];
        for (int x = 0; x < m; x++)
            for (int y = 0; y < n; y++) 
                for (int z = 0; z <= N; z++)
                    map[x][y][z] = -1;
        return helper(m, n, N, i, j, map);
    }
    
    public int helper(int m, int n, int N, int i, int j, int[][][] map){
        if (i < 0 || i >= m || j < 0 || j >= n)
            return 1;
        else if (map[i][j][N] != -1)
            return map[i][j][N];
        else if (N == 0) {
            map[i][j][N] = 0;
        }
        else {
            int cnt = 0;
            cnt += helper(m, n, N-1, i+1, j, map)%1000000007;
            cnt += helper(m, n, N-1, i-1, j, map)%1000000007;
            cnt = cnt%1000000007;
            cnt += helper(m, n, N-1, i, j+1, map)%1000000007;
            cnt = cnt%1000000007;
            cnt += helper(m, n, N-1, i, j-1, map)%1000000007;
            cnt = cnt%1000000007;
            map[i][j][N] = cnt;
        }
        return map[i][j][N];
    } 
}