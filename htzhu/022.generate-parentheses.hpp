class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        string path;
        dfs(n, 0, path, ans);
        return ans;
    }
    void dfs(int n, int k, string &path, vector<string> &ans) {
        if(n == 0 && k == 0) {
            ans.push_back(path);
            return;
        }
        if(n > 0) {
            path.push_back('(');
            dfs(n - 1, k + 1, path, ans);
            path.pop_back();
        }
        if(k > 0) {
            path.push_back(')');
            dfs(n, k - 1, path, ans);
            path.pop_back();
        }
    }
};
