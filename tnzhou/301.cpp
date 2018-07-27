class Solution {
public:
    vector<string> result;
    
    void dfs_left(string s, int idx) {
        for (int i = 0, cnt = 0; i < s.size(); i++) {
            if (s[i] == '(')
                cnt++;
            if (s[i] == ')')
                cnt--;
            if (cnt < 0) {
                for (int j = idx; j <= i; j++) {
                    if (s[j] == ')' && (j == idx || s[j - 1] != ')')) {
                        // Found invalid
                        dfs_left(s.substr(0, j) + s.substr(j + 1), j);
                    }
                }
                return;
            }
        }
        dfs_right(s, s.size() - 1);
    }
    
    void dfs_right(string s, int idx) {
        for (int i = s.size() - 1, cnt = 0; i >= 0; i--) {
            if (s[i] == ')')
                cnt++;
            if (s[i] == '(')
                cnt--;
            if (cnt < 0) {
                for (int j = idx; j >= i; j--) {
                    if (s[j] == '(' && (j == idx || s[j + 1] != '(')) {
                        // Found invalid
                        dfs_right(s.substr(0, j) + s.substr(j + 1), j);
                    }
                }
                return;
            }
        }
        result.push_back(s);
    }
    
    vector<string> removeInvalidParentheses(string s) {
        dfs_left(s, 0);
        return result;
    }
};
