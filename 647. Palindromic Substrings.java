public class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1))
                return 3;
            else
                return 2;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            cnt += 1;
        }
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                cnt += 1;
            }
            else
                dp[i][i+1] = false;
        }
        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i + len-1 < s.length(); i++) {
                if (dp[i+1][i+len-2] == true && s.charAt(i) == s.charAt(i + len-1)) {
                    dp[i][i + len-1] = true;
                    cnt += 1;
                }  
            }
        }
        return cnt;
    }
}