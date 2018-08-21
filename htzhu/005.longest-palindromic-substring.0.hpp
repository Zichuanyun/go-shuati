class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size();
        int start = 0, max_len = 0;
        for(int i = 0; i < n; i++) {
            int len = expand(i, i, s);
            if(i < n - 1) {
                len = max(len, expand(i, i + 1, s));
            }
            if(len > max_len) {
                start = i - (len - 1) / 2;
                max_len = len;
            }
        }
        return s.substr(start, max_len);
    }
    int expand(int i, int j, string &s) {
        int n = s.size();
        while(i >= 0 && j < n && s[i] == s[j]) {
            i--;
            j++;
        }
        return j - i - 1;
    }
};
