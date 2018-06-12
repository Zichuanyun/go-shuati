class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length<2 || k == 0){
            return 0;
        }
        if(k>prices.length/2){
            //same as unlimitate trade time, Stock II
            int result = 0;
            for(int i = 1;i < prices.length; i++){
                result += prices[i]-prices[i-1]>0?prices[i] - prices[i-1] : 0;
            }
            return result;
        }
        int[] hold = new int[k];
        int[] sold = new int[k];
        for(int i = 0; i < k; i++){
            hold[i] = Integer.MIN_VALUE;
            sold[i] = 0;
        }
        
        for(int price: prices){
            for(int i = k-1; i > 0; i--){
                sold[i] = Math.max(sold[i], hold[i] + price);
                hold[i] = Math.max(hold[i], sold[i-1] - price);
            }
            sold[0] = Math.max(sold[0], hold[0]+price);
            hold[0] = Math.max(hold[0], 0-price);
        }
        return sold[k-1];
    }
}
