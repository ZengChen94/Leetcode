public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int new_digits = 0;

        for (int i = digits.length-1; i >= 0; i--){
            new_digits = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = new_digits;
        }
        if (carry > 0){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
        else
            return digits;
    }
}