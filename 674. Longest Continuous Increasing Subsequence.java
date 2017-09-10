class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int cnt = 1;
        int max = 1;
        if (nums.length == 0)
            return 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                cnt += 1;
                max = Math.max(cnt, max);
            } 
            else 
                cnt = 1;
        }
        return max;
    }
}