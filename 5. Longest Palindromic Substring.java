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
// http://blog.csdn.net/hopeztm/article/details/7932245