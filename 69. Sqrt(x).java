public class Solution {
    public int mySqrt(int x) {
        //Newton's Iterative Method
        long r = x;
        while (r * r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
}