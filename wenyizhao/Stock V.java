public int maxProfit(int[] prices) {
    //dp problem
    //sell, buy
    //sell[i]=max(sell[i-1], buy[i-1]+price);
    //buy[i]=max(buy[i-1], sell[i-2]-price);

    int[] sell = new int[prices.length];
    int[] buy = new int[prices.length];
    if(prices.length<=1) return 0;
    sell[0]=0;
    buy[0]=-prices[0];
    sell[1]=Math.max(sell[0], buy[0]+prices[1]);
    buy[1]=Math.max(-prices[1], buy[0]);
    for(int i = 2; i < prices.length; i++){
        sell[i]=Math.max(sell[i-1], buy[i-1]+prices[i]);
        buy[i]=Math.max(buy[i-1], sell[i-2]-prices[i]);
    }
    return Math.max(sell[prices.length-1],buy[prices.length-1]);
}
