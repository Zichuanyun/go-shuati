class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0) {
            return 0;
        }
        int cash_pre = 0, cash = 0, hold = -prices[0];
        for(const auto& price:prices) {
            int tmp = cash;
            cash = max(cash, hold + price);
            hold = max(hold,cash_pre - price);
            cash_pre = tmp;
        }
        return cash;
    }
};
