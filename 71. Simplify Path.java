public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) 
                stack.pop();
            else if (!dir.equals("..") && !dir.equals(".") && !dir.equals("")) 
                stack.push(dir);
        }
        String result = "";
        for (String dir : stack) 
            result = result + "/" + dir;
        return result.isEmpty() ? "/" : result;
    }
}