public class Solution {
    public int[] singleNumber(int[] nums) {
        // Pass 1 : 
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        int tmp = 1;
        while ((diff & 1) != 1) {
            tmp <<= 1;
            diff >>= 1;
        }
        
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & tmp) == 0) // the bit is not set, divide nums into two groups
                rets[0] ^= num;
            else // the bit is set
                rets[1] ^= num;
        }
        return rets;
    }
}