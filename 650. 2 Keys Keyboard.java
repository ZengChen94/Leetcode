public class Solution {
    public int minSteps(int n) {
        if (n == 1 || n == 0)
            return 0;
        int cnt = 0;
        while (n != 1) {
            int tmp = minFactor(n);
            cnt += 1 + tmp - 1;
            n = n / tmp;
        }
        return cnt;
    }
    
    private int minFactor(int n) {
        for (int i = n-1; i >= 1; i--) {
            if (n % i == 0)
                return n / i;
        }
        return n;
    }
}