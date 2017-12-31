class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int[] state = new int[bottom.length()];
        int t = 0;
        for (char c: bottom.toCharArray())
            state[t++] = 1 << (c - 'A');

        int[][] T = new int[7][7];
        for (String a: allowed)
            T[a.charAt(0) - 'A'][a.charAt(1) - 'A'] |= 1 << (a.charAt(2) - 'A');

        while (--t > 0) {
            for (int i = 0; i < t; ++i) {
                int k = 0;
                for (int b1 = 0; b1 < 7; ++b1) if (((state[i] >> b1) & 1) != 0)
                    for (int b2 = 0; b2 < 7; ++b2) if (((state[i+1] >> b2) & 1) != 0)
                        k |= T[b1][b2];
                state[i] = k;
            }
        }
        return state[0] > 0;
    }
}