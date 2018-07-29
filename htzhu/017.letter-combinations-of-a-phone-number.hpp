class Solution {
    const vector<string> table =
        {
         "",
         "",
         "abc",
         "def",
         "ghi",
         "jkl",
         "mno",
         "pqrs",
         "tuv",
         "wxyz"
        };
public:
    vector<string> letterCombinations(string digits) {
        if(digits.empty()) return {};
        string path;
        vector<string> ans;
        dfs(0, digits, path, ans);
        return ans;
    }
    void dfs(int p, string &digits, string &path, vector<string> &ans) {
        int n = digits.size();
        if(p == n) {
            ans.push_back(path);
            return;
        }
        const auto &letters = table[digits[p] - '0'];
        for(char c: letters) {
            path.push_back(c);
            dfs(p + 1, digits, path, ans);
            path.pop_back();
        }
    }
};
