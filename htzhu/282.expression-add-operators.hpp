#define LL long long
class Solution {
public:
    vector<string> addOperators(string num, int target) {
        vector<string> ans;
        dfs(0, num, "", 0, 0, target, ans);
        return ans;
    }
    void dfs(int p, string &num, string path, LL eval, LL multed, int target, vector<string> &ans) {
        int n = num.size();
        if(p == n) {
            if(eval == target) ans.push_back(path);
            return;
        }
        for(int i = p; i < n; i++) {
            if(i != p && num[p] == '0') break;
            string s = num.substr(p, i - p + 1);
            LL cur = stol(s);
            if(p == 0) {
                dfs(i + 1, num, s, cur, cur, target, ans);
            } else {
                dfs(i + 1, num, path + "+" + s, eval + cur, cur, target, ans);
                dfs(i + 1, num, path + "-" + s, eval - cur, -cur, target, ans);
                dfs(i + 1, num, path + "*" + s, eval - multed + multed * cur, multed * cur, target, ans);
            }
        }
    }
};
