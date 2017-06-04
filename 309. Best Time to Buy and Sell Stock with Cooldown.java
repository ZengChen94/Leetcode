// buy[i]  = max(rest[i-1] - price, buy[i-1]) 
// sell[i] = max(buy[i-1] + price, sell[i-1])
// rest[i] = sell[i-1]

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] rest = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        rest[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            buy[i] = Math.max(rest[i-1] - price, buy[i-1]);
            sell[i] = Math.max(buy[i-1] + price, sell[i-1]);
            rest[i] = sell[i-1];
        }
        return sell[prices.length-1];
    }
}

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[1] = Math.max(prices[1]-prices[0], 0);
        for (int i = 2; i < prices.length; i++) {
            int price = prices[i];
            buy[i] = Math.max(sell[i-2] - price, buy[i-1]);
            sell[i] = Math.max(buy[i-1] + price, sell[i-1]);
        }
        return sell[prices.length-1];
    }
}