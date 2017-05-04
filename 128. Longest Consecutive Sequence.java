public class Solution {
    public int longestConsecutive(int[] num) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            int numTmp = num[i];
            int cnt = 0;
            if (!map.containsKey(numTmp)) {
                int leftLen = (map.containsKey(numTmp - 1)) ? map.get(numTmp - 1) : 0;
                int rightLen = (map.containsKey(numTmp + 1)) ? map.get(numTmp + 1) : 0;
                cnt = leftLen + rightLen + 1;
                result = Math.max(cnt, result);
                map.put(numTmp, cnt);
                map.put(numTmp-leftLen, cnt);
                map.put(numTmp+rightLen, cnt);
            }
            else {
                continue;
            }
        }
        return result;
    }
}