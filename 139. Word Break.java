public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (word.length()<=i+1) {
                    if (s.substring(i+1-word.length(), i+1).equals(word) && (i-word.length() == -1 || dp[i-word.length()])) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        
        return dp[s.length()-1];
    }
}