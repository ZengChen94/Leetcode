public class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length+2];  
        for(int i = 1; i < nums.length + 1; ++i)
            arr[i] = nums[i-1];  
        arr[0] = arr[nums.length+1] = 1;  
          
        int[][] dp = new int[nums.length+2][nums.length+2];  
        int n = nums.length+2;  
        
        for (int len = 2; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                for (int k = i+1; k <= j-1; k++)
                    dp[i][j] = Math.max(dp[i][j], dp[i][k]+dp[k][j]+arr[i]*arr[k]*arr[j]);
            }
        }
        
        return dp[0][n-1];  
    }
}