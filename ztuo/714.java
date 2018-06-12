class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i] - fee);
        }
        return sell[prices.length - 1];
    }
}