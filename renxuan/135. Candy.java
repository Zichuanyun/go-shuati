class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; ++i) {
            if(i == 0 || ratings[i] <= ratings[i - 1]) {
                dp[i] = 1;
            }
            else dp[i] = dp[i - 1] + 1;
        }
        int res = 0;
        for(int i = n - 1; i >= 0; --i) {
            if(i < n - 1 && ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i], dp[i + 1] + 1);
            }
            res += dp[i];
        }
        return res;
    }
}
