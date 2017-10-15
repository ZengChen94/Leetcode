class Solution {
    public int countBinarySubstrings(String s) {
        if (s.length() <= 1)
            return 0;
        int result = 0;
        for (int i = 1; i < s.length();) {
            if (s.charAt(i) != s.charAt(i-1)) {
                int left = i-1;
                int right = i;
                while (left-1>=0&&right+1<s.length()&&s.charAt(left-1)==s.charAt(left)&&s.charAt(right+1)==s.charAt(right)){
                    left--;
                    right++;
                }
                result += i-left;
                i = right+1;
            }
            else
                i++;
        }
        return result;
    }
}

//prevRunLength && curRunLength
public int countBinarySubstrings(String s) {
    int prevRunLength = 0, curRunLength = 1, res = 0;
    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == s.charAt(i-1)) curRunLength++;
        else {
            prevRunLength = curRunLength;
            curRunLength = 1;
        }
        if (prevRunLength >= curRunLength) res++;
    }
    return res;
}