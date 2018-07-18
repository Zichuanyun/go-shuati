class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;
        for(auto &s: strs) {
            mp[hashStr(s)].push_back(s);
        }
        vector<vector<string>> ans;
        for(auto &pr: mp) ans.push_back(pr.second);
        return ans;
    }
    string hashStr(const string &s) {
        int cnt[26] = {0};
        for(char c: s) cnt[c - 'a']++;
        string res(' ', s.size());
        for(int i = 0, j = 0; j < 26; j++) {
            for(int k = 0; k < cnt[j]; k++) res[i++] = j + 'a';
        }
        return res;
    }
};
