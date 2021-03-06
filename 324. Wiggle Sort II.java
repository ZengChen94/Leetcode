// https://discuss.leetcode.com/topic/32929/o-n-o-1-after-median-virtual-indexing
// Vietual Index
public class Solution {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);//important!!!
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

		// Here I think we can only travel the odd one and adjust some of them to even index.
        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }
    
    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    
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