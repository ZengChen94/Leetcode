public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length+1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        for (int i = k; i < sum.length; i++) {
            int tmp = (sum[i] - sum[i-k]);
            max = Math.max(max, tmp);
        }
        return (double)max/k;
    }
}