public class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;
        
        char[] sArray = s.toCharArray();
        
        int start = 0, end = s.length()-1;
        while (start <= end) {
            char tmp = sArray[start];
            sArray[start] = sArray[end];
            sArray[end] = tmp;
            start++;
            end--;
        }
        
        int i = 0;
        while (i < s.length()){
            if ((i == 0 && sArray[i] != ' ') || (i != 0 && sArray[i] != ' ' && sArray[i-1] == ' ')) {
                start = i;
                while (i < s.length()) {
                    if ((i == s.length()-1 && sArray[i] != ' ') || (i != s.length()-1 && sArray[i] != ' ' && sArray[i+1] == ' ')) {
                        end = i;
                        break;
                    }
                    i++;
                }
                while (start <= end) {
                    char tmp = sArray[start];
                    sArray[start] = sArray[end];
                    sArray[end] = tmp;
                    start++;
                    end--;
                }
            }
            i++;
        }
        
        String result = new String(sArray).trim();
        result = result.replaceAll(" +"," ");
        
        return result;
    }
}