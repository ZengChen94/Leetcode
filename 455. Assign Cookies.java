public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        for(int j = 0; cnt < g.length && j < s.length; j++) {
            if(g[cnt] <=s [j]) 
                cnt++;
        }
        return cnt;
    }
}