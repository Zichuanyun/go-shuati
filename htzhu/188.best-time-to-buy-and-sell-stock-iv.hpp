class Solution {
public:
    int maxProfit(int K, vector<int>& prices) {
        int n = prices.size();
        if(n < 2) return 0;
        if(K >= n / 2) {
            return maxProfit(prices);
        } else {
            vector<vector<int>> f(K + 1, vector<int>(n));
            for(int k = 1; k <= K; k++) {
                int localMax = -prices[0];
                for(int i = 1; i < n; i++) {
                    f[k][i] = max(f[k][i-1], prices[i] + localMax);
                    localMax = max(localMax, f[k-1][i] - prices[i]);
                }
            }
            return f[K][n-1];
        }
    }
    int maxProfit(vector<int> &prices) {
        int ans = 0;
        int n = prices.size();
        for(int i = 1; i < n; i++) {
            while(i < n && prices[i] < prices[i-1]) i++;
            int buy = prices[i-1];
            while(i < n && prices[i] > prices[i-1]) i++;
            ans += prices[i-1] - buy;
        }
        return ans;
    }
};
