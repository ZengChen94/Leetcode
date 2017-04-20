public class Solution {
    public int reverse(int x) {
        int result = 0;
        int carry = 0;
        int tmp = 0;
        while (x != 0) {
            carry = x % 10;
            x = x / 10;
            tmp = result * 10 + carry;
            if ((tmp - carry)/10 != result) // important
                return 0;
            result = tmp;
        }
        return result;
    }
}