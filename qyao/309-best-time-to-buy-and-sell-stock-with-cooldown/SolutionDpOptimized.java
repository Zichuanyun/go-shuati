import static java.lang.Math.max;

class Solution {
  /**
   * canBuy[k] = max(
   *   cannotBuy[k-2], // waiting for cool down
   *   canBuy[k-1] // doing nothing
   * )
   * cannotBuy[k] = max(canBuy[i] - price[i] + price[k]) // buying and selling
   * This time with the optimization of memorizing the max (canBuy[i] - price[i]) so far, so we only need to max it with the next canBuy[i] - price[i]
   */
  public int maxProfit(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }

    int[] cannotBuy = new int[prices.length]; // max profit with selling on that day
    int[] canBuy =
        new int[prices.length]; // max profit without selling on that day (or the day before)

    int maxBuyableMinusPriceSoFar = canBuy[0] - prices[0];
    for (int date = 1; date < prices.length; date++) {
      if (date > 1) {
        canBuy[date] = max(cannotBuy[date - 2], canBuy[date - 1]);
      }
      maxBuyableMinusPriceSoFar =
          max(maxBuyableMinusPriceSoFar, canBuy[date - 1] - prices[date - 1]);
      cannotBuy[date] = maxBuyableMinusPriceSoFar + prices[date];
    }

    return max(
        max(
            cannotBuy[prices.length - 1], // sometimes it's good to sell on the last day
            cannotBuy[prices.length - 2]), // sometimes it's good to sell on the last day
        canBuy[prices.length - 1] // sometimes both of these are not good ideas
        );
  }
}

