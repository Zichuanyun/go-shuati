class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        int INF = amount + 1;
        vector<int> dp(amount + 1, INF);
        dp[0] = 0;
        for(int i = 1; i <= n; i++)
            for(int j = 0; j <= amount; j++) {
                if(j >= coins[i-1] && dp[j-coins[i-1]] != INF)
                    dp[j] = min(dp[j], dp[j-coins[i-1]] + 1);
            }
        return dp[amount] == INF ? -1 : dp[amount];
    }
};
