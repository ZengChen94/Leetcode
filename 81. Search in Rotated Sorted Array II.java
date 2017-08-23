public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0; 
        int end = nums.length - 1;
        int mid = 0;
        
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target || nums[start] == target || nums[end] == target) {
                return true;
            }
            if (nums[mid] < nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } 
                else {
                    end = mid - 1;
                }
            } 
            else if (nums[mid] > nums[start]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } 
                else {
                    start = mid + 1;
                }
            } 
            else {//here is very important, when can not make a decision, then move to next step
                start++;
                end--;
            }
        }
        
        return false;
    }
}

