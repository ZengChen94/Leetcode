public class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        int a = 1;
        int b = 2;
        int result = 0;
        for (int i = 0; i < n-2; i++){
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}