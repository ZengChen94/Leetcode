public class Solution {
    public int findMin(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        
        int index = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i-1]){
                index = index + 1;
                nums[index] = nums[i];
            }
        }
        if (nums[index] == nums[0]) index = index - 1;
        
        int start = 0;
        int end = index;
        int mid = 0;
        while (start < end){
            mid = (start + end) / 2;
            if (mid > 0 && nums[mid] < nums[mid-1]) return nums[mid];
            
            if (nums[mid] > nums[end]) start = mid + 1;
            else if (nums[mid] < nums[start]) end = mid - 1;
            else return nums[start];
        }
        return nums[start];
    }
}