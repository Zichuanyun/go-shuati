class Solution {
  /*
   * Going from left to right while keeping track of 1. smallest element so far 2. highest (max - min) so far
   */
  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int smallestSoFar = prices[0];
    int highestProfitSoFar = 0;
    for (int price : prices) {
      smallestSoFar = Math.min(smallestSoFar, price);
      highestProfitSoFar = Math.max(highestProfitSoFar, price - smallestSoFar);
    }
    return highestProfitSoFar;
  }
}
