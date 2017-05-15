public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        
        int maxsofar = nums[0];
        int minsofar = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int maxsofarTmp = Math.max(Math.max(maxsofar*nums[i], minsofar*nums[i]), nums[i]);
            int minsofarTmp = Math.min(Math.min(maxsofar*nums[i], minsofar*nums[i]), nums[i]);
            maxsofar = maxsofarTmp;
            minsofar = minsofarTmp;
            result = Math.max(result, maxsofar);
        }
        
        return result;
    }
}