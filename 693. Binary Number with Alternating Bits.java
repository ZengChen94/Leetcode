class Solution {
    public boolean hasAlternatingBits(int n) {
        while (n >= 3) {
            int a = n & 1;
            int b = (n & 3 - a) >> 1;
            if (a == b)
                return false;
            else 
                n = n >> 1;
        }
        return true;
    }
}