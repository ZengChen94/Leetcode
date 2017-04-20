public class Solution {
    public boolean isPalindrome(int x) {
        if (x == Integer.MIN_VALUE) return false;
        if (x < 0) return false; // negative integer are defined as palindrome
        if (x <= 9) return true;
        int d = 1;
        int tmp = x;
        while (tmp >= 10) {
        	tmp = tmp / 10;
        	d = d * 10;
        }
        while(true){
            if (d < 10) return true;
            if (x % 10 == x / d){
                int left = x / d;
                x = (x - left - left * d) / 10;
                d = d / 100;
                continue;
            }
            else
                return false;
        }
    }
}