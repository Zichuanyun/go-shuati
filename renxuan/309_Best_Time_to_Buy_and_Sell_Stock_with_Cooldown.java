class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int buyToday = 0, buyYesterday = Integer.MIN_VALUE, sellToday = 0, sellYesterday = 0, sellTwoDaysAgo = 0;
        for(int price : prices) {
            buyToday = Math.max(buyYesterday, sellTwoDaysAgo - price);
            sellToday = Math.max(sellYesterday, buyYesterday + price);
            sellTwoDaysAgo = sellYesterday; sellYesterday = sellToday; buyYesterday = buyToday;
        }
        return sellToday;
    }
}