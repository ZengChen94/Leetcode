public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        int[] count = new int[amount];
        return helper(coins, amount, count);
    }
    
    //dfs
    private int helper(int[] coins, int remain, int[] count) {
        if(remain < 0) return -1;
        if(remain == 0) return 0; // completed
        if(count[remain-1] != 0) return count[remain-1]; // already computed, so reuse
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = helper(coins, remain - coin, count);
            if(res >= 0 && res < min)
                min = 1 + res;
        }
        count[remain-1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remain-1];
    }
}