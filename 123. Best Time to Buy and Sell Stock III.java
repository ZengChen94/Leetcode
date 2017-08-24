public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] fromStartToEnd = new int[prices.length];
        int[] fromEndToStart = new int[prices.length];
        
        int minSoFar = prices[0];
        int maxResult = 0;
        for (int i = 0; i < prices.length; i++) {
            minSoFar = prices[i] < minSoFar? prices[i] : minSoFar;
            maxResult = prices[i]-minSoFar > maxResult? prices[i]-minSoFar : maxResult;
            fromStartToEnd[i] = maxResult;
        }
        
        int maxSoFar = prices[prices.length-1];
        maxResult = 0;
        for (int i = prices.length-1; i >= 0; i--) {
            maxSoFar = prices[i] > maxSoFar? prices[i] : maxSoFar;
            maxResult = maxSoFar-prices[i] > maxResult? maxSoFar-prices[i] : maxResult;
            fromEndToStart[i] = maxResult;
        }
        
        maxResult = 0;
        for (int i = 0; i < prices.length; i++) {
            maxResult = Math.max(maxResult, fromStartToEnd[i]+fromEndToStart[i]);
        }
        
        return maxResult;
    }
}

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        else {
            int k = 2;
            int maxProf = 0;
            int[][] matrix = new int[k+1][prices.length];
            for (int i = 1; i <= k; i++){
                int tmpMax = matrix[i-1][0] - prices[0];//after first buy
                for (int j = 1; j < prices.length; j++){
                    matrix[i][j] = Math.max(matrix[i][j-1], tmpMax + prices[j]);//after sell
                    tmpMax = Math.max(tmpMax, matrix[i-1][j] - prices[j]);//after buy
                    maxProf = Math.max(matrix[i][j], maxProf);
                }
            }
            return maxProf;
        }
    }
}