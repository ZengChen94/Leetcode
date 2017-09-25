class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() == 0)
            return true;
        int i = 0; 
        int j = s.length() - 1;
        for (; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                if (helper(s, i+1, j))
                    return true;
                else if (helper(s, i, j-1))
                    return true;
                else
                 return false;   
            }
        }
        return true;
    }
    
    public boolean helper(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}