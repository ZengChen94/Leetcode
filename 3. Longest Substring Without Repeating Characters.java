public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();//it records the last time the chracher appears
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null) {
                int position = map.get(s.charAt(i));
                if (position + 1 > j) 
                    j = position + 1;
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}