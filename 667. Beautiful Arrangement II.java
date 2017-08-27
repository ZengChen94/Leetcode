// https://discuss.leetcode.com/topic/101113/c-java-clean-code-4-liner
class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++)
            res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : (k % 2 != 0? l++ : r--);
        return res;
    }
}