class Solution {
public:
    int maxProfit(vector<int>& prices) {
        // doing one-pass: keeping track of two variables, min-price and max-profit
        // if the next node is lower than this one, update min-price
        // if it is greater, then see if the profit exceeds the maximum profit
        if (prices.size() == 0) {
            return 0;
        }
        
        int min_price = prices[0];
        int max_profit = 0;
        
        for (int i = 1; i < prices.size(); i++) {
            if (prices[i] < min_price) {
                min_price = prices[i];
            }
            else {
                max_profit = max(max_profit, prices[i] - min_price);
            }
        }
        
        return max_profit;
    }
};
