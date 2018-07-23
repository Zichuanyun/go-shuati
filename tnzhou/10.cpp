class Solution {
public:
    bool isMatch(string s, string p) {
        return dfs(s, p, 0, 0);
    }
    
    bool dfs(string& s, string& p, int sidx, int pidx) {
        if (sidx == s.length() && pidx == p.length())
            return true;
        if (pidx == p.length())
            return false;
        
        bool res = false;

        if (pidx + 1 < p.length() && p[pidx + 1] == '*') {
            if (p[pidx] == '*')
                return false;
            if (sidx < s.length() && (s[sidx] == p[pidx] || p[pidx] == '.')) {
                res |= dfs(s, p, sidx + 1, pidx);
            }
            res |= dfs(s, p, sidx, pidx + 2);
        } else if (sidx < s.length() && (s[sidx] == p[pidx] || p[pidx] == '.')) {
            res |= dfs(s, p, sidx + 1, pidx + 1);
        }
        return res;
    }
};
