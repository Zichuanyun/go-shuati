class Solution {
public:
    bool PredictTheWinner(vector<int>& nums) {
        int n = nums.size();
        if(n < 2) return true;
        vector<vector<int>> dp(n, vector<int>(n));
        for(int i = 0; i < n; i++)
            dp[i][i] = nums[i];
        vector<int> sum(n);
        sum[0] = nums[0];
        for(int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + nums[i];
        for(int len = 1; len < n; len++)
            for(int i = 0; i + len < n; i++) {
                int j = i + len;
                dp[i][j] = max(nums[i] + sum[j] - sum[i] - dp[i + 1][j],
                               nums[j] + sum[j - 1] - (i > 0 ? sum[i - 1] : 0) - dp[i][j - 1]);
            }
        return dp[0][n - 1] >= sum[n - 1] - dp[0][n-1];
    }
};
