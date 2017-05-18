public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0)
            return 0;
        int result = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            result <<= 1;
        }
        result = result * m;
        return result;
    }
}