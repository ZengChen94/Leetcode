public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = new String();
        if(strs.length == 0) // important  
        	return "";
        int j = 0;
        while (true){
            int flag = 0;
            for (int i = 0; i < strs.length; i++){
            	if (j >= strs[i].length() || j >= strs[0].length()){ // important
                    flag = 1;
                    break;
                }
                if (strs[i].charAt(j) == strs[0].charAt(j))
                    continue;
                else{
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                result += strs[0].charAt(j);
            else
            	break;
            j = j + 1;
        }
        return result;
    }
}