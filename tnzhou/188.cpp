class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        int n = prices.size();
        k = min(n, k);
        vector<int> fbuy(k + 1, -2147483647);
        vector<int> fsell(k + 1, 0);
        for (int i = 0; i < n; i ++) {
            for (int j = 1; j <= k; j ++) {
                fbuy[j] = max(fsell[j - 1] - prices[i], fbuy[j]);
                fsell[j] = max(fbuy[j] + prices[i], fsell[j]);
            }
        }
        int max_profit = 0;
        for (int i = 1; i <= k; i++)
            max_profit = max(max_profit, fsell[i]);
        return max_profit;
    }
};  
