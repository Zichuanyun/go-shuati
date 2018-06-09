class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxPro = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxPro = Math.max(maxPro, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return maxPro;
    }
}
