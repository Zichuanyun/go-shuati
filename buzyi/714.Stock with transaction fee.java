public int maxProfit(int[] prices){
    int sell = 0;
    int hold = Integer.MIN_VALUE;
    
    for (int price : prices) {
        int prevSell = sell;
        sell = Math.max(sell, hold+ price);
        hold = Math.max(hold, prevSell - price - fee);
    }
        
    return sell;
}
