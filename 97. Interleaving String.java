public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0) return s2.equals(s3);
        if (s2.length() == 0) return s1.equals(s3);
        if (s3.length() == 0) 
            if (s1.length() == 0 && s2.length() == 0) return true;
            else return false;
        if (s1.length()+s2.length()!=s3.length()) return false;
        
        boolean[][] result = new boolean[s1.length()+1][s2.length()+1];
        result[0][0] = true;
        
        for (int i = 1; i <= s1.length(); i++){
            if (result[i-1][0]==true && s1.charAt(i-1) == s3.charAt(i-1)) result[i][0] = true;
            else break;
        }
        
        for (int i = 1; i <= s2.length(); i++){
            if (result[0][i-1]==true && s2.charAt(i-1) == s3.charAt(i-1)) result[0][i] = true;
            else break;
        }
        
        for (int i = 1; i <= s1.length(); i++){
            for (int j = 1; j <= s2.length(); j++){
                if (result[i-1][j] == true && s1.charAt(i-1) == s3.charAt(i+j-1)) result[i][j] = true;
                else if (result[i][j-1] == true && s2.charAt(j-1) == s3.charAt(i+j-1)) result[i][j] = true;
                else result[i][j] = false;
            }
        }
        return result[s1.length()][s2.length()];
    }
}