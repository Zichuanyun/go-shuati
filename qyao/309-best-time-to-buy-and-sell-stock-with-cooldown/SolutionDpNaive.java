import java.util.Arrays;

import static java.lang.Math.max;

class Solution {
  /**
   * canBuy[k] = max(
   *   cannotBuy[k-2], // waiting for cool down
   *   canBuy[k-1] // doing nothing
   * )
   * cannotBuy[k] = max(canBuy[i] - price[i] + price[k]) // buying and selling
   */
  public int maxProfit(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }

    int[] cannotBuy = new int[prices.length]; // max profit with selling on that day
    int[] canBuy = new int[prices.length]; // max profit without selling on that day (or the day before)
    for (int date = 1; date < prices.length; date++) {
      if (date > 1) {
        canBuy[date] = max(cannotBuy[date - 2], canBuy[date-1]);
      }
      int maxWithoutSubtractPrice = canBuy[0] - prices[0];
      // TODO optimize this part
      for (int buyDate = 0; buyDate < date; buyDate++) {
        maxWithoutSubtractPrice = max(
          maxWithoutSubtractPrice,
          canBuy[buyDate] - prices[buyDate]
        );
      }
      cannotBuy[date] = maxWithoutSubtractPrice + prices[date];
    }

    return max(
      max(cannotBuy[prices.length-1], // sometimes it's good to sell on the last day
      cannotBuy[prices.length-2]), // sometimes it's good to sell on the last day
      canBuy[prices.length-1] // sometimes both of these are not good ideas
    );
  }
}

