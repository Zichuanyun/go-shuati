class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE, sell = 0;
        for(int price : prices) {
            int oldBuy = buy;
            buy = Math.max(oldBuy, sell - price - fee);
            sell = Math.max(sell, oldBuy + price);
        }
        return sell;
    }
}