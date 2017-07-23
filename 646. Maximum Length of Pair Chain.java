public class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0)
            return 0;
        Arrays.sort(pairs, (a, b)->(a[0]-b[0]));
        int cnt = 0;
        int prev = pairs[0][0]-1;
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] > prev) {
                cnt += 1;
                prev = pairs[i][1];
            }
            else if(pairs[i][1] < prev) {
                prev = pairs[i][1];
            }
        }
        return cnt;
    }
}