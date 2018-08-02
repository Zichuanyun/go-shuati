class Solution {
    public int numTilings(int N) {
        long[] dp = new long[Math.max(4, N + 1)];
        dp[0] = 1; dp[1] = 1; dp[2] = 2; dp[3] = 5;
        int M = 1000000007;
        for (int i = 4; i <= N; i++) {
            dp[i] = 2 * dp[i - 1] + dp[i - 3];
            dp[i] %= M;
        }
        return (int)dp[N];
    }
}
