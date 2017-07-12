public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] chars = new int[26];
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length())
            return result;
        
        for (char c : p.toCharArray())
            chars[c-'a']++;

        int start = 0, end = 0, count = p.length();
        
        while (end < s.length()) {
            if (end - start == p.length()) {
                if (chars[s.charAt(start)-'a'] >= 0)
                    count++;
                chars[s.charAt(start)-'a'] += 1;
                start += 1;
            }
            
            chars[s.charAt(end)-'a'] -= 1;
            if (chars[s.charAt(end)-'a'] >= 0)
                count--;
            end += 1;
            
            if (count == 0)
                result.add(start);
        }

        return result;
    }
}