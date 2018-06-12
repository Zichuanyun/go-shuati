class Solution {
public:
    string minWindow(string s, string t) {
        int n = s.size();
        int mp[128] = {0};
        int cnt = 0, start = 0, len = n + 1;
        for(char c: t) {
            cnt++;
            mp[c]++;
        }
        for(int i = 0, j = 0; j < n;) {
            if(mp[s[j++]]-- > 0) {
                cnt--;
            }
            while(cnt == 0 && i < j) {
                if(j - i < len) {
                    start = i;
                    len = j - i;
                }
                if(mp[s[i++]]++ == 0) cnt++;
            }
        }
        return len == n + 1 ? "" : s.substr(start, len);
    }
};
