class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length <= 2) return true;
        int sum = 0, n = nums.length;
        for(int num : nums) sum += num;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; ++i) dp[i][i] = nums[i];
        for(int i = 0; i < n - 1; ++i) dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
        for(int k = 2; k < n; ++k) {
            for(int l = 0; l < n - k; ++l) {
                int r = l + k;
                dp[l][r] = Math.max(nums[l] + Math.min(dp[l + 2][r], dp[l + 1][r - 1]), 
                                    nums[r] + Math.min(dp[l][r - 2], dp[l + 1][r - 1]));
            }
        }
        return dp[0][n - 1] * 2 >= sum;
    }
}
