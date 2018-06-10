class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        int n = prices.size();
        if(n < 2) return 0;
        vector<int> s = {0, -prices[0], 0};
        int m = s.size();
        for(int i = 1; i < n; i++) {
            vector<int> new_s(m);
            new_s[0] = max(s[0], s[2]);
            new_s[1] = max(max(s[1], s[0] - prices[i]), s[2] - prices[i]);
            new_s[2] = max(s[2], s[1] + prices[i] - fee);
            s = new_s;
        }
        return max(s[0], s[2]);
    }
};
