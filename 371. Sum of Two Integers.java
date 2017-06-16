public class Solution {
    //http://blog.csdn.net/qq508618087/article/details/51789576
    public int getSum(int a, int b) {
        if (a == 0) return b;
    	if (b == 0) return a;
    
    	while (b != 0) {
    		int carry = a & b;
    		a = a ^ b;
    		b = carry << 1;
    	}
    	
    	return a;
    }
}