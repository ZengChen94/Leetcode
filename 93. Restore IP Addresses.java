public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        String newString = new String();
        for (int i = 1; i <= 3; i++){
        	if (i > s.length()-3 || i < s.length()-9) continue;
            int a = Integer.parseInt(s.substring(0, i));
            if (a!=0 && s.charAt(0)=='0') continue;
            if (a==0 && i!=1) continue;
            if (a < 0 || a > 255) continue;
            for (int j = 1; j <= 3; j++){
            	if (i+j > s.length()-2 || i+j < s.length()-6) continue;
                int b = Integer.parseInt(s.substring(i, i+j));
                if (b!=0 && s.charAt(i)=='0') continue;
                if (b==0 && j!=1) continue;
                if (b < 0 || b > 255) continue;
                for (int k = 1; k <= 3; k++){
                	if (i+j+k > s.length()-1 || i+j+k < s.length()-3) continue;
                    int c = Integer.parseInt(s.substring(i+j, i+j+k));
                    if (c!=0 && s.charAt(i+j)=='0') continue;
                    if (c==0 && k!=1) continue;
                    if (c < 0 || c > 255) continue;
                    int d = Integer.parseInt(s.substring(i+j+k, s.length()));
                    if (d!=0 && s.charAt(i+j+k)=='0') continue;
                    if (d==0 && s.length()-i-j-k!=1) continue;
                    if (d < 0 || d > 255) continue;
                    newString = "";
                    newString = String.valueOf(a) + '.' + String.valueOf(b) + '.' + String.valueOf(c) + '.' + String.valueOf(d);
                    result.add(newString);
                }
            }
        }
        return result;
    }
}