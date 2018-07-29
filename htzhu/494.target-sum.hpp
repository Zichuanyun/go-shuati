class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int S) {
        const int MAX_VAL = 1000;
        if(S > MAX_VAL || nums.empty()) return 0;
        int n = nums.size();
        vector<int> dp(MAX_VAL * 2 + 1), nextDp(MAX_VAL * 2 + 1);
        dp[nums[0] + MAX_VAL] = 1;
        dp[-nums[0] + MAX_VAL]++;
        for(int i = 1; i < n; i++) {
            fill(nextDp.begin(), nextDp.end(), 0);
            for(int sum = -MAX_VAL; sum <= MAX_VAL; sum++) {
                int offsetSum = sum + MAX_VAL;
                if(dp[offsetSum] > 0) {
                    nextDp[offsetSum + nums[i]] += dp[offsetSum];
                    nextDp[offsetSum - nums[i]] += dp[offsetSum];
                }
            }
            dp.swap(nextDp);
        }
        return dp[S + MAX_VAL];
    }
};
