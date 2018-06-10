class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int max_profit = 0;
        int cur_profit = 0;
        if (prices.size() == 0 or prices.size() == 1)
            return 0;
        for (int i = 1; i < prices.size(); i ++) {
            if (prices[i] > prices[i - 1])
                max_profit += prices[i] - prices[i - 1];
        }
        return max_profit;
    }
};
