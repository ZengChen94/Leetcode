public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int first = 0;
        int second = 0;
        for (first = nums.length-1; first >= 1; first--) {
            if (nums[first-1] < nums[first])
                break;
        }
        
        if (first == 0)
            nums = reverse(nums, 0);
        else {
            first = first-1;
            for (second = nums.length-1; second > first; second--){
                if (nums[second] > nums[first]){
                    int tmp = nums[first];
                    nums[first] = nums[second];
                    nums[second] = tmp;
                    break;
                }
            }
            nums = reverse(nums, first+1);
        }
        
        return;
    }
    
    public int[] reverse(int[] nums, int position){
        int first = position;
        int last = nums.length-1;
        while(first < last){
            int tmp = nums[first];
            nums[first] = nums[last];
            nums[last] = tmp;
            first ++;
            last --;
        }
        
        return nums;
    }
}