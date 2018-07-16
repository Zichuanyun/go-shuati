public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;
        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n + 1][k];
        for(int i = 1; i <= n; ++i) {
            int min = -1, secondMin = -1;
            for(int t = 0; t < k; ++t) {
                if(min == -1 || dp[i-1][t] < dp[i-1][min]) {
                    secondMin = min;
                    min = t;
                }
                else if(secondMin == -1 || dp[i-1][t] < dp[i-1][secondMin]) {
                    secondMin = t;
                }
            }
            
            for(int j = 0; j < k; ++j) {
                if(j == min) 
                    dp[i][j] = dp[i-1][secondMin] + costs[i-1][j];
                else dp[i][j] = dp[i-1][min] + costs[i-1][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int t = 0; t < k; ++t) {
            min = Math.min(min, dp[n][t]);
        }
        return min;
    }
}
