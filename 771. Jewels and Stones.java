class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<Character>();
        int res = 0;
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            set.add(c);
        }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (set.contains(c))
                res += 1;
        }
        return res;
    }
}