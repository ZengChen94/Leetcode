public class Solution {
    public String[] findWords(String[] words) {
        List<String> result = new LinkedList<>();
        String string1 = "qwertyuiopQWERTYUIOP";
        String string2 = "asdfghjklASDFGHJKL";
        String string3 = "zxcvbnmZXCVBNM";
        Set<Character> set1 = new HashSet<Character>();
        Set<Character> set2 = new HashSet<Character>();
        Set<Character> set3 = new HashSet<Character>();
        for (int i = 0; i < string1.length(); i++) 
            set1.add(string1.charAt(i));
        for (int i = 0; i < string2.length(); i++) 
            set2.add(string2.charAt(i));
        for (int i = 0; i < string3.length(); i++) 
            set3.add(string3.charAt(i));
        for (String word : words) {
            int flag = 0;
            if (set1.contains(word.charAt(0))) {
                for (int i = 0; i < word.length(); i++) {
                    if (!set1.contains(word.charAt(i))) {
                        flag = 1;
                        break;
                    }
                }
            }
            else if (set2.contains(word.charAt(0))) {
                for (int i = 0; i < word.length(); i++) {
                    if (!set2.contains(word.charAt(i))) {
                        flag = 1;
                        break;
                    }
                }
            }    
            else if (set3.contains(word.charAt(0))) {
                for (int i = 0; i < word.length(); i++) {
                    if (!set3.contains(word.charAt(i))) {
                        flag = 1;
                        break;
                    }
                }
            }    
            if (flag == 0)
                result.add(word);
        }
        return result.toArray(new String[0]);
    }
}