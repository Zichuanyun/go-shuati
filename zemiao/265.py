class Solution:
    """
    @param costs: n x k cost matrix
    @return: an integer, the minimum cost to paint all houses
    """
    def minCostII(self, costs):
      if not costs:
        return 0
      n, k = len(costs), len(costs[0])

      # dp[i]: minCost for costs[i:]
      dp = []
      
      for i in reversed(range(n)):
        newDP = costs[i]
        if dp:
          lastMinIndex = dp.index(min(dp))
          min1 = dp[lastMinIndex]
          min2 = min(dp[:lastMinIndex]+dp[lastMinIndex+1:]) if len(dp)>1 else None
          for j in range(k):
            if j != lastMinIndex:
              newDP[j] += min1
            elif min2:
              newDP[j] += min2
            else:
              return -1
        
        dp = newDP

      return min(dp) if dp else -1