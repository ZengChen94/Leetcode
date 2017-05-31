public class Solution {
    //The main idea is the same with problem Linked List Cycle II,https://leetcode.com/problems/linked-list-cycle-ii/. 
    public int findDuplicate(int[] nums) {
        if (nums.length <= 1) 
            return -1;
    	
		int slow = nums[0];
		int fast = nums[nums[0]];
		
		while (slow != fast)
		{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		fast = 0;
		while (fast != slow)
		{
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
    }
}