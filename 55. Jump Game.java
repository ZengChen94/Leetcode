public class Solution {
    public boolean canJump(int[] nums) {
        int reach = 1;
        for (int i = 0; i < reach && reach < nums.length; i++)
            reach = Math.max(reach, i + 1 + nums[i]);
        return reach >= nums.length;
    }
}