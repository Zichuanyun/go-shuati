class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k >= prices.length / 2) {
            return unlimited(prices);
        }
        int[][] sell = new int[k + 1][prices.length];
        for(int i = 1; i <= k; i++) {
            int buy =  - prices[0];
            for(int j = 1; j < prices.length; j++) {
                sell[i][j] = Math.max(buy + prices[j], sell[i][j-1]);
                buy =  Math.max(buy, sell[i-1][j-1] - prices[j]);
            }
        }
        return sell[k][prices.length - 1];
    }
    public int unlimited(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) profit += prices[i] - prices[i-1];
        }
        return profit;
    }
}