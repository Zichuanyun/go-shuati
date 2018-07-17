class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        vector<string> ans, lvl, tlvl;
        unordered_set<string> vis;
        if(isValid(s)) return {s};
        lvl.push_back(s);
        vis.insert(s);
        while(!lvl.empty()) {
            tlvl.clear();
            for(auto &s: lvl) {
                int n = s.size();
                for(int i = 0; i < n; i++) {
                    if(s[i] == '(' || s[i] == ')') {
                        string t = s.substr(0, i) + s.substr(i + 1);
                        if(vis.count(t)) continue;
                        vis.insert(t);
                        if(isValid(t)) {
                            ans.push_back(t);
                        } else {
                            tlvl.push_back(t);
                        }
                    }
                }
            }
            if(!ans.empty()) return ans;
            lvl.swap(tlvl);
        }
        return ans;
    }
    bool isValid(const string &s) {
        int stk = 0;
        for(auto c: s) {
            if(c == '(') stk++;
            else if(c == ')') stk--;
            if(stk < 0) return false;
        }
        return stk == 0;
    }
};
