class Solution {
    vector<vector<int>> memo;
public:
    bool isMatch(string s, string p) {
        int m = s.size(), n = p.size();
        memo = vector<vector<int>>(m + 1, vector<int>(n + 1, -1));
        memo[m][n] = 1;
        return dfs(0, s, 0, p);
    }
    int dfs(int i, string &s, int j, string &p) {
        int m = s.size(), n = p.size();
        if(memo[i][j] != -1) return memo[i][j];
        int res = 0;
        if(i == m) {
            if(j + 1 < n && p[j+1] == '*') {
                res = dfs(i, s, j + 2, p);
            } else {
                res = 0;
            }
        } else if(j == n){
            res = 0;
        } else if(j + 1 < n && p[j+1] == '*'){
            if(dfs(i, s, j + 2, p)) {
                res = 1;
            } else if(p[j] == '.' || s[i] == p[j]){
                res = dfs(i + 1, s, j, p);
            }
        } else {
            if(p[j] == '.' || s[i] == p[j]) {
                res = dfs(i + 1, s, j + 1, p);
            }
        }
        return memo[i][j] = res;
    }
};
