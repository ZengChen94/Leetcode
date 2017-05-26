public class Solution {
    // voting
    public int majorityElement(int[] nums) {
        int result = 0;
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0)
                result = num;
            if (num == result)
                cnt++;
            else
                cnt--;
        }
        return result;
    }
}