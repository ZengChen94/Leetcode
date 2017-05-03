public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0 ;
        int max = 0 ;
        int sofarMin = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            sofarMin = prices[i] < sofarMin? prices[i] : sofarMin;
            max = (prices[i] - sofarMin) > max? (prices[i] - sofarMin) : max;
        }
        return max;
    }
}