class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target? 0 : -1;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            if (low + 1 == high) {
                if (nums[low] == target)
                    return low;
                else if (nums[high] == target)
                    return high;
                else
                    return -1;
            }
            else {
                int mid = (low + high) / 2;
                if (nums[low] < nums[mid]) {
                    if (nums[low] <= target && target <= nums[mid])
                        high = mid;
                    else 
                        low = mid;
                }
                else {
                    if (nums[mid] <= target && target <= nums[high])
                        low = mid;
                    else
                        high = mid;
                }
            }
        }
        return -1;
    }
}