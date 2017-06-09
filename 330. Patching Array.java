public class Solution {
    public int minPatches(int[] nums, int n) {
        int cnt = 0;
        long maxsofar = 0;
        int i = 0;
        while (maxsofar < (long)n) {
            if (i < nums.length) {
                if (maxsofar < (long)(nums[i] - 1)) {
                    cnt += 1;
                    maxsofar = maxsofar * 2 + (long)1;
                }
                else {
                    maxsofar = maxsofar + (long)nums[i];
                    i += 1;
                }
            }
            else {
                cnt += 1;
                maxsofar = maxsofar * 2 + (long)1;
            }
        }
        return cnt;
    }
}