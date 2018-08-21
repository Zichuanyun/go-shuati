class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<int> cnt(128);
        int repeat_cnt = 0;
        int ans = 0;
        for(int i = 0, j = 0; j < s.size();) {
            if(++cnt[s[j++]] == 2) repeat_cnt++;
            while(repeat_cnt > 0) {
                if(--cnt[s[i++]] == 1) repeat_cnt--;
            }
            ans = max(ans, j - i);
        }
        return ans;
    }
};
