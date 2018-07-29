class Solution {
public:
    bool isMatch(string s, string p) {
        int m = s.size(), n = p.size();
        vector<vector<int>> memo(m + 1, vector<int>(n + 1, -1));
        memo[m][n] = 1;
        return dfs(0, s, 0, p, memo);
    }
    bool dfs(int i, string &s, int j, string &p, vector<vector<int>> &memo) {
        int m = s.size(), n = p.size();
        if(memo[i][j] != -1) return memo[i][j];
        int res;
        if(i == m) {
            res = (p[j] == '*' && dfs(i, s, j + 1, p, memo));
        } else if(j == n) {
            res = 0;
        } else if(p[j] == '*') {
            res = (dfs(i + 1, s, j, p, memo) || dfs(i, s, j + 1, p, memo));
        } else if(p[j] == '?' || s[i] == p[j]) {
            res = dfs(i + 1, s, j + 1, p, memo);
        } else {
            res = 0;
        }
        return memo[i][j] = res;
    }
};
