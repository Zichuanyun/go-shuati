/*
Time:o(n); space:o(1)

*/

public int maxProfit(int[] prices){
    int sell = 0;
    int preSell = 0;
    int buy = Integer.MIN_VALUE;
    int preBuy = 0;
    for(int price : prices){
        preBuy = buy;
        buy = Math.max(preSell- price, preBuy);
        preSell = sell;
        sell = Math.max(preBuy + price,preSell);
    }
    return sell;
}
