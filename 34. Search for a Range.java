class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length-1])
            return new int[]{-1, -1};
        if (nums.length == 1) {
            return nums[0] == target? new int[]{0, 0} : new int[]{-1, -1};
        }
        int index1 = -1;
        int index2 = -1;
        
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            if (low + 1 == high) {
                if (nums[low] == target)
                    index1 = low;
                else if (nums[high] == target)
                    index1 = high;
                break;
            }
            int mid = (low + high) / 2;
            if (nums[mid] >= target)
                high = mid;
            else if (nums[mid] < target)
                low = mid;
        }
        
        low = 0;
        high = nums.length - 1;
        while (low < high) {
            if (low + 1 == high) {
                if (nums[high] == target)
                    index2 = high;
                else if (nums[low] == target)
                    index2 = low;
                break;
            }
            int mid = (low + high) / 2;
            if (nums[mid] > target)
                high = mid;
            else if (nums[mid] <= target)
                low = mid;
        }
        
        return new int[]{index1, index2};
    }
}