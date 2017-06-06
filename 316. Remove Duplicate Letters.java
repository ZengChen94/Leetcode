public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] array = new int[26];
        int[] visit = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a'] += 1;
        }
        String result = new String("");
        
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            array[tmp - 'a'] -= 1;
            if (visit[tmp - 'a'] == 1) 
                continue;
            while (result.length() != 0) {
                char tmp2 = result.charAt(result.length()-1);
                if (array[tmp2 - 'a'] != 0 && tmp < tmp2) {
                    visit[tmp2 - 'a'] = 0;
                    result = result.substring(0, result.length()-1);
                }
                else {
                    break;
                }
            }
            result += tmp;
            visit[tmp - 'a'] = 1;
        }
        
        return result;
    }
}