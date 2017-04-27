public class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0) return;
        int start = 0;
        int end = nums.length-1;
        
        for (int i = 0; i <= end; ){
            if (nums[i] == 0){
                int tmp = nums[i];
                nums[i] = nums[start];
                nums[start] = tmp; //nums[start] cannot be 0 because i has run over it
                start++;
                i++;
            }
            else if (nums[i] == 2){
                int tmp = nums[i];
                nums[i] = nums[end];
                nums[end] = tmp;
                end--;
            }
            else 
                i++;
        }
        return;
    }
}