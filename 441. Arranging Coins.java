public class Solution {
    public int arrangeCoins(int n) {
        long start = 0;
        long end = (long)n;
        
        long mid = 0;
        
        while (start <= end){
            mid = start + (end - start) / 2;
            
            if (mid * (mid + 1) <= 2 * (long)n){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        
        return (int)(start - 1);
    }
}