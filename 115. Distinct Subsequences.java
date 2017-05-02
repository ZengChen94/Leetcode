public class Solution {
    public int numDistinct(String S, String T) {
        int[][] bp = new int[T.length()+1][S.length()+1];

        for(int j = 0; j <= S.length(); j++) {
            bp[0][j] = 1;
        }
        
        for(int i = 1; i <= T.length(); i++) {
            for(int j = 1; j <= S.length(); j++) {
                if(T.charAt(i-1) == S.charAt(j-1)) {
                    membp[j] = bp[i-1][j-1] + bp[i][j-1];
                } else {
                    bp[i][j] = bp[i][j-1];
                }
            }
        }
        
        return bp[T.length()][S.length()];
    }
}