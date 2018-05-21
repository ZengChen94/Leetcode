class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int max = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (set.contains(s.charAt(j))) {
                while (i < j) {
                    set.remove(s.charAt(i));
                    i += 1;
                    if (s.charAt(i-1) == s.charAt(j)) {
                        break;
                    }
                }
                set.add(s.charAt(j));
                max = Math.max(j-i+1, max);
            }
            else {
                set.add(s.charAt(j));
                max = Math.max(j-i+1, max);
            }
        }
        return max;
    }
}