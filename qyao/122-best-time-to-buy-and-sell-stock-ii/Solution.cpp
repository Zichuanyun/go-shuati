class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0 || prices.size() == 1) return 0;
        // for every interval, if it is increasing, then add it to the cumulative profit
        int profit = 0;
        for (int i = 1; i < prices.size(); i++) {
            profit += max(prices[i] - prices[i-1], 0);
        }
        return profit;
    }
};
