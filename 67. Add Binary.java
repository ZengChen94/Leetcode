public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()){ // make sure that a.length >= b.length
            String tmp = a;
            a = b;
            b = tmp;
        }
        String result = new String();
        int carry = 0;
        int i = 0;
        int j = 0;
        for (i = a.length()-1, j = b.length()-1; j >= 0; i--, j--){
            int tmp = a.charAt(i)-'0' + b.charAt(j)-'0' + carry;
            carry = tmp / 2;
            tmp = tmp % 2;
            result = tmp + result;
        }
        for (; i >= 0; i--){
            int tmp = a.charAt(i)-'0'+carry;
            carry = tmp / 2;
            tmp = tmp % 2;
            result = tmp + result;
        }
        if (carry != 0)
            result = carry + result;
        return result;
    }
}