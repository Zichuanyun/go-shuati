class Solution {
  /*
   * 2D Dynamic Programming. dp[i][j] means the highest profit possible on day i by only making j transactions.
   * dp[i][j] = max(
   *     dp[i-1][j], // do nothing and wait until tomorrow
   *     dp[i-d][j-1] + prices[i] - prices[i-d] // buying at day i-d and selling on day i, for all possible d < i
   * )
   * And as the value of dp[i-d][j-1] - prices[i-d] does not change inside the loop, therefore we could memorize the previous values and only compare it to the next profitBeforeMinusPriceBefore
   * TODO this solution can be further optimized as now dp[i][j] only depend on dp[i-1][j-1] and dp[i-1][j] so we could swap the inner and outer for loops and only keep track of 2 previous variables, using only a total of 4 variables for DP.
   */
  public int maxProfit(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }

    int[][] dp = new int[prices.length][3];
    for (int numTransactions = 1; numTransactions <= 2; numTransactions++) {
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
    return dp[prices.length - 1][2];
  }
}
