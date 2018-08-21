class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size();
        if(n < 2) return s;
        vector<vector<bool>> dp(n, vector<bool>(n));
        int start = 0, len = 1;
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            if(i > 0 && s[i-1] == s[i]) {
                dp[i-1][i] = true;
                start = i - 1;
                len = 2;
            }
        }
        for(int k = 2; k < n; k++) {
            for(int i = 0; i + k < n; i++) {
                int j = i + k;
                if(s[i] == s[j] && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    start = i;
                    len = k + 1;
                }
            }
        }
        return s.substr(start, len);
    }
};
