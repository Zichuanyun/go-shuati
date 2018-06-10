class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minv = INT_MAX;
        int ans = 0;
        for(int x: prices) {
            ans = max(ans, x - minv);
            minv = min(minv, x);
        }
        return ans;
    }
};
