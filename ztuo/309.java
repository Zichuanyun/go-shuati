class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        int[] rest = new int[prices.length];
        sell[0] = 0;
        rest[0] = 0;
        buy[0] = - prices[0];
        for(int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
            rest[i] = Math.max(sell[i-1], rest[i-1]);
            buy[i] = Math.max(rest[i-1]-prices[i], buy[i-1]);
        }
        return sell[prices.length-1];
    }
}