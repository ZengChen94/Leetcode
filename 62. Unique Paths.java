public class Solution {
    public int uniquePaths(int m, int n) {
        int N = n + m - 2;
        int k = Math.min(m - 1, n - 1);
        double result = 1;
        for (int i = 1; i <= k; i++)
            result = result * (N - k + i) / i;
        return (int) Math.round(result);
    }
}