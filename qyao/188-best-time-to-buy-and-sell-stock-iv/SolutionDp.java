class Solution {
  /*
    * A straight-forward generalization from the mildly optimized solution of stock-iii. Just with a checking that if k > numDays / 2, we can make as much transactions as we want, therefore switch to the stock-i solution so our memory don't explode.
   */

  public int maxProfit(int k, int[] prices) {
    if (prices.length < 2) {
      return 0;
    }

    // if k is greater than number of days / 2, we can make as many transactions as we want
    if (k > prices.length / 2) {
      int profit = 0;
      for (int i = 1; i < prices.length; i++) {
        if (prices[i] > prices[i-1]) {
          profit += prices[i] - prices[i-1];
        }
      }
      return profit;
    }

    int[][] dp = new int[prices.length][k+1];
    for (int numTransactions = 1; numTransactions <= k; numTransactions++) {
      int maxProfitBeforeMinusPriceBefore =
        dp[0][numTransactions - 1] - prices[0]; // initialize to day 0
      for (int today = 1; today < prices.length; today++) {
        maxProfitBeforeMinusPriceBefore =
          Math.max(
            maxProfitBeforeMinusPriceBefore,
            dp[today - 1][numTransactions - 1] - prices[today - 1]);
        dp[today][numTransactions] =
          Math.max(
            dp[today - 1][numTransactions], maxProfitBeforeMinusPriceBefore + prices[today]);
      }
    }
    return dp[prices.length - 1][k];
  }
}
