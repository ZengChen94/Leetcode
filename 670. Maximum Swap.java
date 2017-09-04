class Solution {
    public int maximumSwap(int num) {
        String num2string = num + "";
        if (num2string.length() < 2)
            return num;
        int i = 1;
        for (; i < num2string.length(); i++) {
            if (num2string.charAt(i)-'0' > num2string.charAt(i-1)-'0')
                break;
        }
        if (i == num2string.length())
            return num;
        int max = num2string.charAt(i)-'0';
        int index = i;
        for (; i < num2string.length(); i++) {
            if (num2string.charAt(i)-'0' >= max) {
                max = num2string.charAt(i)-'0';
                index = i;
            }
        }
        for (i = 0; i < num2string.length(); i++) {
            if (num2string.charAt(i)-'0' < max) {
                if (index == num2string.length()-1)
                    num2string = num2string.substring(0, i) + num2string.charAt(index) + num2string.substring(i+1, index) + num2string.charAt(i);
                else
                    num2string = num2string.substring(0, i) + num2string.charAt(index) + num2string.substring(i+1, index) + num2string.charAt(i) + num2string.substring(index+1, num2string.length());
                break;
            }
        }
        return Integer.parseInt(num2string);
    }
}