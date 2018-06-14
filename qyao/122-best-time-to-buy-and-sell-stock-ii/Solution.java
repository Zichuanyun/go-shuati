class Solution {
  /*
   * When the price is always rising, holding off for a few day before selling is the same as always buying today and selling tomorrow. When it first falls then rises, you just shouldn't buy today.
   * Therefore you should always just buy today and sell tomorrow when it could make profit. It is at least as profitable as any other approach.
   * This is basically just profit += Math.max(0, tomorrow - today) for each day
   */
  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      profit += Math.max(0, prices[i] - prices[i - 1]);
    }

    return profit;
  }
}
