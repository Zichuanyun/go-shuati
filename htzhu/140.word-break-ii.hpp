class Solution {
    unordered_set<string> dic;
    unordered_map<int, vector<string>> memo;
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        dic = unordered_set<string>(wordDict.begin(), wordDict.end());
        return dfs(0, s);
    }
    vector<string> dfs(int p, const string &s) {
        int n = s.size();
        if(p == n) return {""};
        if(memo.count(p)) return memo[p];
        auto &res = memo[p];
        for(int i = p; i < n; i++) {
            string left = s.substr(p, i - p + 1);
            if(dic.count(left)) {
                for(auto &t: dfs(i + 1, s)) {
                    res.push_back(left + (t.empty() ? t : " " + t));
                }
            }
        }
        return res;
    }
};
