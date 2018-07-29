class Solution {
public:
    int combinationSum4(vector<int>& nums, int target) {
        int n = nums.size(), m = target;
        vector<int> dp(m + 1);
        dp[0] = 1;
        for(int i = 1; i <= m; i++) {
            for(int num: nums) {
                if(i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[m];
    }
};
