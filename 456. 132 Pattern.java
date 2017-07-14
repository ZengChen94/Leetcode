public class Solution {
    public boolean find132pattern(int[] nums) {
        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            //first
            if (nums[i] < third) 
                return true;
            else 
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    third = stack.pop(); 
                }
            //second: increasing stack
            s.push(nums[i]);
        }
        return false;
    }
}