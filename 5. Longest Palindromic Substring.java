// dp
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        String result = s.substring(0, 1);
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i+len-1<s.length(); i++) {
                if (len == 1) {
                    dp[i][i] = true;
                }
                else if (len == 2 && s.charAt(i) == s.charAt(i+1)) {
                    dp[i][i+1] = true;
                    result = s.substring(i, i+len);
                }
                else {
                    if (s.charAt(i) == s.charAt(i+len-1) && dp[i+1][i+len-2]) {
                        dp[i][i+len-1] = true;
                        result = s.substring(i, i+len);
                    }
                }
            }
        }
        return result;
    }
}

// extend
public class Solution {
    int low, maxLength;

    public String longestPalindrome(String s) {
    	int len = s.length();
    	if (len < 2)
    		return s;
    	
        for (int i = 0; i < len - 1; i++) {
         	extendPalindrome(s, i, i); //assume odd length
         	extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(low, low + maxLength);
    }
    
    private void extendPalindrome(String s, int j, int k) {
    	while (j >= 0 && k < s.length()) {
    	    if (s.charAt(j) == s.charAt(k)) {
    	        j--; k++;
    	    }
    		else
    		    break;
    	}
    	if (maxLength < k - j - 1) {
    		low = j + 1;
    		maxLength = k - j - 1;
    	}
    }
}

// Method 2
// Manacher’s Algorithm
// https://www.cnblogs.com/grandyang/p/4475985.html