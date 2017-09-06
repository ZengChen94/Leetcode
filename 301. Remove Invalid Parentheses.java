public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<String>();
        List<String> result = new LinkedList<String>();
        int start = 0;
        int end = s.length()-1;
        String stringStart = new String("");
        String stringEnd = new String("");
        String string = new String("");
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                start = i;
                break;
            }
        }
        for (int i = 0; i < start; i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')')
                stringStart += s.charAt(i);
        }
		
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                end = i;
                break;
            }
        }
        for (int i = s.length()-1; i > end; i--) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')')
                stringEnd = s.charAt(i) + stringEnd;
        }
        
        String s2;
        if (end >= start)
            s2 = s.substring(start, end+1);
        else
            s2 = "";
        
        int num1 = 0, num2 = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == '(') {
                num1++;
            } else if (s2.charAt(i) == ')') {
                if (num1 != 0) {
                    num1--;
                } else {
                    num2++;
                }
            }
        }
        
        dfs(s2, 0, set, string, 0, num1, num2);
            
        if (s2.equals("")){
        	for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) != '(' && s.charAt(i) != ')')
                    string += s.charAt(i);
            result.add(string);
        }
        else
        	for (String str : set) {     
        		result.add(stringStart + str + stringEnd);
        	}
        
        return result;
    }
    
    public void dfs(String s, int index, Set<String> set, String string, int stack, int removeNum1, int removeNum2) {
        if (index == s.length()) {
            if (stack == 0 && removeNum1 == 0 && removeNum2 == 0){
                set.add(string);
            } 
            return;
        }
        
        if (s.charAt(index) != '(' && s.charAt(index) != ')') {
            string += s.charAt(index);
            dfs(s, index+1, set, string, stack, removeNum1, removeNum2);
        }
        else if (s.charAt(index) == '(') {
            dfs(s, index+1, set, string+'(', stack+1, removeNum1, removeNum2);
            if (removeNum1 > 0)
                dfs(s, index+1, set, string, stack, removeNum1-1, removeNum2);
        }
        else {
            if (stack > 0)
                dfs(s, index+1, set, string+')', stack-1, removeNum1, removeNum2);
            if (removeNum2 > 0)
                dfs(s, index+1, set, string, stack, removeNum1, removeNum2-1);
        }
        return;
    }
}