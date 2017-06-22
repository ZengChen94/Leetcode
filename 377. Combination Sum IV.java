public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] memory = new int[target+1];
        Arrays.fill(memory, -1);
        memory[0] = 1;
        helper(nums, target, memory);
        return memory[target];
    }
    
    public int helper(int[] nums, int target, int[] memory) {
        if (memory[target] == -1) {
            int tmp = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= target) 
                    tmp += helper(nums, target-nums[i], memory);
            }
            memory[target] = tmp;
        }
        return memory[target];
    }
}