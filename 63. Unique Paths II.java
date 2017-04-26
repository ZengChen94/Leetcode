public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /* 
        //2D dp
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i == 0){
                    dp[0][j] = obstacleGrid[0][j] == 1? 0 : dp[0][j-1];
                }
                else if(j == 0){
                    dp[i][0] = obstacleGrid[i][0] == 1? 0 : dp[i-1][0];
                }
                else {
                    dp[i][j] += obstacleGrid[i][j] == 1? 0 : (dp[i-1][j]+dp[i][j-1]);
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
        */
        
        //1D dp
        int[] dp = new int[obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 1) return 0;
        dp[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (j == 0){
                    if (obstacleGrid[i][0] == 0) 
                        continue;
                    else
                        dp[0] = 0;
                }
                else {
                    if (obstacleGrid[i][j] == 0)
                        dp[j] += dp[j-1];
                    else
                        dp[j] = 0;
                }
            }
        }
        return dp[obstacleGrid[0].length-1];
    }
}