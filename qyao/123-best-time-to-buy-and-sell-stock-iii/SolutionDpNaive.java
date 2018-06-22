@SuppressWarnings({"unused", "UnnecessaryReturnStatement"})
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] prices = new int[] {3, 3, 5, 0, 0, 3, 1, 4};
    System.out.println(s.maxProfit(prices));
  }

  /*
   * 2D Dynamic Programming. dp[i][j] means the highest profit possible on day i by only making j transactions.
   * dp[i][j] = max(
   *     dp[i-1][j], // do nothing and wait until tomorrow
   *     dp[i-d][j-1] + prices[i] - prices[i-d] // buying at day i-d and selling on day i, for all possible d < i
   * )
   */
  public int maxProfit(int[] prices) {
    int[][] dp = new int[prices.length][3];
    for (int numTransactions = 1; numTransactions <= 2; numTransactions++) {
      for (int today = 1; today < prices.length; today++) {
        // profitBeforeBuying + prices[now] - prices[before] is going to be the new profit
        // and profitBeforeBuying is tied with prices[before] so we could just find out the date
        // before today that has maximum of this
        int profitBeforeMinusPricesBefore =
            dp[0][numTransactions - 1] - prices[0]; // initialize to day 0
        for (int buyDate = 0; buyDate < today; buyDate++) {
          profitBeforeMinusPricesBefore =
              Math.max(
                  profitBeforeMinusPricesBefore,
                  dp[buyDate][numTransactions - 1] - prices[buyDate]);
        }
        dp[today][numTransactions] =
            Math.max(dp[today - 1][numTransactions], profitBeforeMinusPricesBefore + prices[today]);
      }
    }
    return dp[prices.length - 1][2];
  }
}
