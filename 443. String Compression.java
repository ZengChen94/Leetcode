class Solution {
    public int compress(char[] chars) {
        if (chars.length <= 1)
            return chars.length;
        int cnt = 0;
        int cntTmp = 1;
        int index = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                cntTmp += 1;
            }
            else {
                cnt += 1;
                chars[index++] = chars[i-1];
                if (cntTmp != 1) {
                    String cntString = cntTmp + "";
                    for (int j = 0; j < cntString.length(); j++)
                        chars[index++] = cntString.charAt(j);
                    cnt += cntString.length();
                }
                cntTmp = 1;
            }
        }
        cnt += 1;
        chars[index++] = chars[chars.length-1];
        if (cntTmp != 1) {
            String cntString = cntTmp + "";
            for (int j = 0; j < cntString.length(); j++)
                chars[index++] = cntString.charAt(j);
            cnt += cntString.length();
        }
        return cnt;
    }
}