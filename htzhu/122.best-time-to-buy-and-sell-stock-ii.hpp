class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        if(n < 2) return 0;
        int ans = 0;
        for(int i = 1; i < n; i++) {
            while(i < n && prices[i] < prices[i-1]) i++;
            int buy = prices[i-1];
            while(i < n && prices[i] > prices[i-1]) i++;
            ans += prices[i-1] - buy;
        }
        return ans;
    }
};
