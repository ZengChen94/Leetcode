public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) return result;
        if (nums.length == 1 && nums[0] != target) return result;
        if (nums.length == 1 && nums[0] == target) return new int[]{0,0};
        
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end){
            int mid = (begin+end)/2;
            if (nums[mid] == target){
                result[0] = mid;
                end = mid-1;
            }
            else if (nums[mid] > target){
                end = mid-1;
            }
            else{
                begin = mid+1;
            }
        }
        
        begin = 0;
        end = nums.length - 1;
        while (begin <= end){
            int mid = (begin+end)/2;
            if (nums[mid] == target){
                result[1] = mid;
                begin = mid+1;
            }
            else if (nums[mid] > target){
                end = mid-1;
            }
            else{
                begin = mid+1;
            }
        }
        
        return result;
    }
}