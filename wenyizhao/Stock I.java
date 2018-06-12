class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2 || prices == null)
            return 0;
        int result=0, min = prices[0];
        for(int price: prices){
            min = Math.min(min, price);
            result = Math.max(result, price-min);
        }
        return result;
    }
}
