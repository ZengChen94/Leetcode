public class Solution {
    public String shortestPalindrome(String s) {
        String reverse = "";
        for (int i = s.length()-1; i >= 0; i--) {
            reverse += s.charAt(i);
        }
        String combine = s + "#" + reverse;
        int[] next = new int[combine.length()];
        
        //kmp -- not traditional kmp
        //string[0], string[1], ... string[next[i-1]-1] == ..., string[i-1]
        for (int i = 1; i < combine.length(); i++) {
            int j = next[i - 1];
            while (j > 0 && combine.charAt(i) != combine.charAt(j)) 
                j = next[j - 1];
            if (combine.charAt(i) == combine.charAt(j))
                next[i] = j + 1;
        }
        
        return reverse.substring(0, s.length() - next[combine.length() - 1]) + s;
    }
}