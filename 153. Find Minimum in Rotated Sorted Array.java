public class Solution {
    public int findMin(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end){
            int mid = (start + end) / 2;
            if (mid > 0 && nums[mid] < nums[mid-1])
                return nums[mid];
            
            if (nums[start] > nums[mid])
                end = mid-1;
            else if (nums[end] < nums[mid])
                start = mid+1;
            else return nums[start];
        }
        
        return nums[start];
    }
}