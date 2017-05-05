public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        int ones_copy = 0, twos_copy = 0;
        for (int i = 0; i < nums.length; i++) {
            ones_copy = ones;
            twos_copy = twos;
            //~nums[i] means which positions are 0
            ones = ((~ones_copy&~twos_copy)&nums[i])|(ones_copy&~nums[i]); // 0+1 or 1+0
            twos = (ones_copy&nums[i])|(twos_copy&~nums[i]); // 1+1 or 2+0
        }
        
        return ones;
    }
}