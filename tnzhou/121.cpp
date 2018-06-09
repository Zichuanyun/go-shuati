class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int max_profit = 0;
        int prices_size = prices.size();
        if (prices_size == 0)
            return 0;
        int lowest_price = prices[0];
        for (int i = 0; i < prices_size; i++) {
            if (prices[i] < lowest_price)
                lowest_price = prices[i];
            if (prices[i] - lowest_price > max_profit)
                max_profit = prices[i] - lowest_price;
        }
        return max_profit;
        
    }
};
