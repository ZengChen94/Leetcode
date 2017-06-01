public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        
        if (words.length != pattern.length())
            return false;
        Map<Character, String> map = new HashMap<Character, String>();
        
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(words[i]))
                    return false;
            }
            else {
                for (String value : map.values())
                    if (value.equals(words[i]))
                        return false;
                map.put(pattern.charAt(i), words[i]);
            }
        }

        return true;
    }
}