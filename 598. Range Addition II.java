public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int min1 = m;
        int min2 = n;
        for (int i = 0; i < ops.length; i++) {
            min1 = Math.min(min1, ops[i][0]);
            min2 = Math.min(min2, ops[i][1]);
        }
        return min1*min2;
    }
}