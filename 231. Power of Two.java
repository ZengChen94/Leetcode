public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

public class Solution {
    public boolean isPowerOfTwo(int n) {
        while (n != 0) {
            if ((n & 1) == 0)
                n >>= 1;
            else {
                if (n == 1)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }
}