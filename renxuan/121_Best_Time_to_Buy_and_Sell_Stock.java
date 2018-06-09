class Solution {
    public int maxProfit(int[] prices) {
        int localMax = 0, globalMax = 0;
        for(int i = 1; i < prices.length; ++i) {
            localMax = Math.max(0, localMax) + prices[i] - prices[i-1];
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
}