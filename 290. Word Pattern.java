public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");//important
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        
        if (words.length != pattern.length())
            return false;
        Map<Character, String> map = new HashMap<Character, String>();
        
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (map.get(pattern.charAt(i)) != words[i])
                    return false;
            }
            else {
                map.put(pattern.charAt(i), words[i]);
            }
        }

        return true;
    }
}