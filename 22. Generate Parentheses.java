public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        if (n == 0) return list;
        list = backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public List<String> backtrack(List<String> list, String str, int open, int close, int max){
        if(str.length() == max * 2){
            list.add(str);
            return list;
        }
        
        if(open < max)
            list = backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            list = backtrack(list, str+")", open, close+1, max);
            
        return list;
    }
}