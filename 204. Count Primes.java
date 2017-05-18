public class Solution {
    public int countPrimes(int n) {
        boolean[] composite = new boolean[n];
        int count = 0;
        
        for (int i = 2; i < n; i++) {
            if (composite[i] == false) {//is Prime
                count++;
                for (int j = 2; i*j < n; j++) {
                    composite[i*j] = true;
                }
            }
        }
        
        return count;
    }
}