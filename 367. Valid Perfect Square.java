public class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 0, high = num;
        while (low <= high) {
            long mid = (long)((low + high) / 2);
            if (mid * mid == (long)num) {
                return true;
            } else if (mid * mid < (long)num) {
                low = (int)mid + 1;
            } else {
                high = (int)mid - 1;
            }
        }
        return false;
    }
}