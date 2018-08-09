#define LL long long

class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        int n = A.size();
        vector<unordered_map<LL, int>> dp(n);
        int ans = 0;
        for(int i = 1; i < n; i++)
            for(int j = 0; j < i; j++) {
                LL diff = (LL)A[i] - (LL)A[j];
                int val = (dp[j].count(diff) ? dp[j][diff] : 0);
                dp[i][diff] += val + 1;
                ans += val;
            }
        return ans;
    }
};
