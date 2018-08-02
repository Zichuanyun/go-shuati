class Solution {
public:
    int numTilings(int N) {
        vector<int> dp(max(N + 1, 3));
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        const int M = 1e9 + 7;
        for(int i = 4; i <= N; i++) {
            dp[i] = (2 * dp[i-1] % M + dp[i-3]) % M;
        }
        return dp[N];
    }
};
