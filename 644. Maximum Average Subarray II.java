public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length+1];        
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        double maxGlobal = (double)(sum[k] - sum[0])/k;
        for (int j = k; j <= nums.length; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = j; i < sum.length; i++) {
                int tmp = (sum[i] - sum[i-j]);
                max = Math.max(max, tmp);
            }
            maxGlobal = maxGlobal > (double)max/j? maxGlobal : (double)max/j;
        }
        return maxGlobal;
    }
}