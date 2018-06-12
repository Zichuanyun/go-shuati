class Solution {
    public int maxProfit(int[] prices) {
        int minPro = Integer.MAX_VALUE;
        int maxPro = 0;
        
        for(int i = 0; i < prices.length; i++){
            minPro = Math.min(minPro, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - minPro);
        }
        return maxPro;
    }
}