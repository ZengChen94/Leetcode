public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> resultTmp = new ArrayList<>();
        int[][] map = new int[s.length()+1][s.length()+1];//0--not visit / 1--visit&true / 2-visit&false
        for (int i = 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(0, i)) == true){
                map[0][i] = 1;
                resultTmp.add(s.substring(0, i));
                helper(s, i, result, resultTmp, map);
                resultTmp.remove(resultTmp.size()-1);
            }
        }
        return result;
    }
    
    public void helper(String s, int pos, List<List<String>> result, List<String> resultTmp, int[][] map) {
        if (pos == s.length()){
            result.add(new ArrayList<>(resultTmp));
            return;
        }
        for (int i = pos+1; i <= s.length(); i++) {
            if (map[pos][i] == 1){
                resultTmp.add(s.substring(pos, i));
                helper(s, i, result, resultTmp, map);
                resultTmp.remove(resultTmp.size()-1);
            }
            else if (map[pos][i] == 2)
                continue;
            else if (isPalindrome(s.substring(pos, i)) == true){
                map[pos][i] = 1;
                resultTmp.add(s.substring(pos, i));
                helper(s, i, result, resultTmp, map);
                resultTmp.remove(resultTmp.size()-1);
            }
            else {
                map[pos][i] = 2;
            }
        }
        return;
    }
    
    public boolean isPalindrome(String str){
        int lower = 0;
        int upper = str.length()-1;
        if(lower == upper) return true;
        while(lower < upper){
            if(str.charAt(lower) != str.charAt(upper)) return false;
            lower++;
            upper--;
        }
        return true;
    }
}