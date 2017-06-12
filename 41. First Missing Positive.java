public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        
        for (int i = 0; i < nums.length; i++){// bucket sort
            while (nums[i] != i+1 && nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                int tmp = nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
            }
        }
        
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != (i + 1))
                return i + 1;
                
        return nums.length + 1;
    }
}

