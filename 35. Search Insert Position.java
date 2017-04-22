public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        if (target <= nums[0]) return 0;
        if (target > nums[nums.length-1]) return nums.length;
         
        int begin = 0;
        int end = nums.length-1;
        while (begin <= end){
            if (target == nums[begin]) return begin;
            if (target == nums[end]) return end;
            if (begin == end-1) return end;
            
            int mid = (begin+end)/2;
            if (target == nums[mid]) return mid;
            
            else if (target < nums[mid]) end = mid;
            else begin = mid;
        }
        return 0;
        
    }
}