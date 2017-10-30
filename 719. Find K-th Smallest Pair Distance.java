class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i] - nums[i - 1]);
        }
        int max = nums[nums.length - 1] - nums[0];
        
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (getNum(nums, mid) < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
    
    private int getNum(int[] nums, int mid) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += firstGreaterThanK(nums, nums[i] + mid) - (i + 1);
        }
        return res;
    }
    
    private int firstGreaterThanK(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}