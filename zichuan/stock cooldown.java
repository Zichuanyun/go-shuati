class Solution {
    public int maxProfit(int[] prices) {
        // corner case
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int s0 = 0, s1 = -prices[0], s2 = 0;
            
        for (int i = 1; i < prices.length; ++i) {
            int price = prices[i];
            int t0 = Math.max(s0, s2);
            int t1 = Math.max(s0 - price, s1);
            int t2 = Math.max(s1 + price, s2);
            
            s0 = t0;
            s1 = t1;
            s2 = t2;
        }
        
        return Math.max(s2, s0);
    }   
}