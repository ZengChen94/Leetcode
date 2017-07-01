public class Solution {
    public int thirdMax(int[] nums) {
        int max1 = -1;
        int max2 = -1;
        int max3 = -1;
        for (int n : nums) {
            if (n == max1 || n == max2 || n == max3) 
                continue;
            if (max1 == -1 || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == -1 || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == -1 || n > max3) {
                max3 = n;
            }
        }
        return max3 == -1 ? max1 : max3;
    }
}