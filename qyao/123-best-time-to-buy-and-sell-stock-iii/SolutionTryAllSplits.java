class Solution {
  /*
   * Idea: supposing there are two transactions, then there must be a point where the first transaction before that and the other after. There are only n of such possibilities, and determining the max profit in the subarray would only take O(n) time as well (with solution to stock-i), therefore we could determine the solution in O(n^2) by trying all the possible splits.
   */
  public int maxProfit(int[] prices) {
    int maxProfitFromTwoTransactions = 0;
    for (int split = 0; split < prices.length; split++) {
      maxProfitFromTwoTransactions =
          Math.max(
              maxProfitFromTwoTransactions,
              maxProfitOneTransaction(prices, 0, split)
                  + maxProfitOneTransaction(prices, split, prices.length));
    }

    return maxProfitFromTwoTransactions;
  }

  /* The maximum profit possible with only one transaction (solution to buy-and-sell-stocks-i) */
  private int maxProfitOneTransaction(int[] prices, int start, int end) {
    if (start - end == 0) {
      return 0;
    }
    int smallestSoFar = prices[start];
    int highestProfitSoFar = 0;
    for (int i = start + 1; i < end; i++) {
      smallestSoFar = Math.min(smallestSoFar, prices[i]);
      highestProfitSoFar = Math.max(highestProfitSoFar, prices[i] - smallestSoFar);
    }
    return highestProfitSoFar;
  }
}
