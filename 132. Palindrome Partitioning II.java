public class Solution {
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];//record whether [i, j] is palindrome or not
        int[] min = new int[s.length()];//record the minimum of partition
        for(int i = 0; i < s.length(); i ++) 
            dp[i][i] = true;
        min[0] = 0;
        
        for(int i = 1; i < s.length(); i++) {
            min[i] = min[i-1] + 1;
            for(int j = 0; j <= i-1; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j == i-1 || dp[i-1][j+1] == true) {
                        dp[i][j] = true;
                        if (j == 0)
                            min[i] = 0;
                        else
                            min[i] = min[i] > min[j-1] + 1? min[j-1] + 1 : min[i];
                    }
                }
            }
        }
        
        return min[s.length()-1];
    }
}