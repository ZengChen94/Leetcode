public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) 
            return false;

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {//can match empty //a*
                dp[0][i+1] = dp[0][i-1];
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {//match single one
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {//can only match empty
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i][j-1] || dp[i][j+1] || dp[i+1][j-1]);//match single one || multiple one || empty
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}