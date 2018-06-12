class Solution {
    public int maxCoins(int[] iNums) {
        int n = iNums.length + 2;
        int[] nums = new int[n];
        nums[0] = nums[n-1] = 1;
        for(int i = 1; i < n-1; ++i)
            nums[i] = iNums[i-1];
        int[][] dp = new int[n][n];
        for(int k = 2; k < n; ++k) {
            for(int left = 0; left < n - k; ++left) {
                int right = left + k;
                for(int i = left + 1; i < right; ++i) {
                    dp[left][right] = Math.max(dp[left][right], dp[left][i] + dp[i][right] + nums[left] * nums[i] * nums[right]);
                }
            }
        }
        return dp[0][n-1];
    }
}