public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;  
        if (dividend < 0) sign = -sign;  
        if (divisor < 0) sign = -sign;  
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        long temp = Math.abs((long)dividend);  
        long temp2 = Math.abs((long)divisor);  
        long c = 1;  
        while(temp > temp2){  
            temp2 = temp2<<1;  
            c = c<<1;  
        }  
        
        int res = 0;  
        while (temp >= Math.abs((long)divisor)){  
            while (temp >= temp2){  
                temp -= temp2;  
                res += c;  
            }  
            temp2 = temp2>>1;  
            c = c>>1;  
        }  
        
        if (sign > 0) return res;  
        else return -res;  
    }
}