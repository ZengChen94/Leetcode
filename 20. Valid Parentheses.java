public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
    	for (int i = 0; i < s.length(); i++) {
    	    char c = s.charAt(i);
    		if (c == '(')
    			stack.push(')');
    		else if (c == '{')
    			stack.push('}');
    		else if (c == '[')
    			stack.push(']');
    		else if (stack.isEmpty())
    			return false;
    		else {
    		     char top = stack.pop();
    		     if (top != c)
    		        return false;
    		}
    	}
    	return stack.isEmpty();
    }
}