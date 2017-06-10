public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= num1)
                num1 = n;
            else if (n <= num2)
                num2 = n;
            else 
                return true;
        }
        return false;
    }
}