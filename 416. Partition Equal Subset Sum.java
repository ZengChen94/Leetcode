public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;
        
        int cnt = 0;
        for (int num : nums)
            cnt += num;
        if (cnt % 2 == 1)
            return false;
        else
            cnt = cnt / 2;
        
        boolean[] dp = new boolean[cnt + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = cnt; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        return dp[cnt];
    }
}