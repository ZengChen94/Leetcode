public class Solution {
    public int findRotateSteps(String ring, String key) {
        int m = key.length();
        int n = ring.length();
        int[][] dp = new int[m][n];
        
        for (int j = 0; j < n; j++){
            dp[0][j] = Integer.MAX_VALUE;
            if (ring.charAt(j) == key.charAt(0)) {
                dp[0][j] = Math.min(Math.abs(j), n-Math.abs(j));
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (key.charAt(i) == ring.charAt(j)) {
                    for (int k = 0; k < n; k++) {
                        if (key.charAt(i-1) == ring.charAt(k)) {
                            dp[i][j] = Math.min(dp[i][j], dp[i-1][k]+Math.abs(k-j));
                            dp[i][j] = Math.min(dp[i][j], dp[i-1][k]+n-Math.abs(k-j));
                        }    
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[m-1][j]);
        }
        return min + m;
    }
}