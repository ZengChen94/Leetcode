public class Solution {
    //quickSelect
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, nums.length-k+1);
    }
    
    int quickSelect(int[] nums, int low, int high, int k) {
        int start = low;
        int end = high;
        int key = nums[low];
        
        while(end > start){
            while(end > start && nums[end] >= key)
                end--;
            if(nums[end] <= key){
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
            }
            while(end > start && nums[start] <= key)
               start++;
            if(nums[start] >= key){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        if(start == k-1) return nums[start];
        else if(start > k-1) return quickSelect(nums, low, start-1, k);
        else return quickSelect(nums, end+1, high, k);
    }
}