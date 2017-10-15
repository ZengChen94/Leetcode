class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % k != 0)
            return false;
        int target = sum / k;
        int[] group = new int[k];
        Arrays.sort(nums);
        return helper(nums, nums.length-1, group, target);
    }
    
    public boolean helper(int[] nums, int index, int[] group, int target) {
        if (index == -1)
            return true;
        for (int i = 0; i < group.length; i++) {
            if (group[i] + nums[index] <= target) {
                group[i] += nums[index];
                if (helper(nums, index-1, group, target))
                    return true;
                group[i] -= nums[index];
            }
        }
        return false;
    }
}