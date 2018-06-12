class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> memo(n, vector<int>(n, -1));
        return dfs(0, n - 1, nums, memo);
    }
    int dfs(int lo, int hi, vector<int> &nums, vector<vector<int>> &memo) {
        if(lo > hi) return 0;
        if(memo[lo][hi] != -1) return memo[lo][hi];
        int n = nums.size();
        int res = 0;
        int l = lo - 1, r = hi + 1;
        int left = (l >= 0 ? nums[l] : 1);
        int right = (r < n ? nums[r] : 1);
        for(int i = lo; i <= hi; i++) {
            int val = nums[i] * left * right + dfs(lo, i - 1, nums, memo) + dfs(i + 1, hi, nums, memo);
            res = max(res, val);
        }
        return memo[lo][hi] = res;
    }
};
