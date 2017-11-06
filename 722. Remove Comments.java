class Solution {
    public List<String> removeComments(String[] source) {
        StringBuilder sb = new StringBuilder();
        for(String s : source)
            sb.append(s).append("\n");
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < sb.length();) {
            int j = sb.indexOf("//", i);
            int k = sb.indexOf("/*", i);
            if (j < 0 && k < 0) {
                sb2.append(sb.substring(i));
                break;
            }
            if (j < 0 || (k >= 0 && k < j)) {
                int end = sb.indexOf("*/", k+2);
                sb2.append(sb.substring(i, k));
                i = end+2;
            } else {
                int end = sb.indexOf("\n", j+2);
                sb2.append(sb.substring(i, j));
                i = end;
            }
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < sb2.length();) {
            int j = sb2.indexOf("\n", i);
            if (j < 0) break;
            if (j > 0 && sb2.charAt(j-1) != '\n') {
                ans.add(sb2.substring(i, j));
            }
            i = j+1;
        }

        return ans;
    }
}