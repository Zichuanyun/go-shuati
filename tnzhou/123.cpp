class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        int maxans = 0;
        vector<int> f(n, 0);
        for (int divpt = 1; divpt < n; divpt ++) {
            int min_buy = prices[0];
            int max_profit1 = 0;     
            for (int i = 0; i <= divpt; i ++) {
                if (prices[i] < min_buy)
                    min_buy = prices[i];
                if (prices[i] - min_buy > max_profit1)
                    max_profit1 = prices[i] - min_buy;
            }
            min_buy = prices[divpt];
            int max_profit2 = 0;
            for (int i = divpt; i < n; i ++) {
                if (prices[i] < min_buy)
                    min_buy = prices[i];
                if (prices[i] - min_buy > max_profit2)
                    max_profit2 = prices[i] - min_buy;
            }
            if (max_profit1 + max_profit2 > maxans)
                maxans = max_profit1 + max_profit2;
        }
        return maxans;
    }
};  
