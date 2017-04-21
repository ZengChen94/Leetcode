public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != nums[tmp]) {
                tmp += 1;
                nums[tmp] = nums[i];
            }
                
        return tmp+1;
    }
}