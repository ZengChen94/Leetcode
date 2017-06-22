// https://discuss.leetcode.com/topic/51946/very-simple-java-solution-with-detail-explanation
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1)
			return nums.length;
		int k = 0;
		while (k < nums.length - 1 && nums[k] == nums[k + 1])
			k++;
		if (k == nums.length - 1) {
			return 1;
		}
		int result = 2;
		boolean flag = nums[k] < nums[k + 1];
		
		for (int i = k + 1; i < nums.length - 1; i++) {
			if (flag && nums[i + 1] < nums[i]) {
				result++;
				flag = !flag;
			} else if (!flag && nums[i + 1] > nums[i]) {
				result++;
				flag = !flag;
			}
		}
		return result;
    }
}