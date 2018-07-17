class Solution {
public:
    int charMapA[26];
    unordered_map <string, string> hash;
    unordered_map <string, int> add_index;

    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        int charMap[26];
        vector<vector<string>> result;
        int len = strs.size();
        for (int i = 0; i < len; i ++) {
            bool added = false;
            string st = strs[i];
            string s = hashAnagram(st);
            if (add_index[s] > 0) {
                result[add_index[s] - 1].push_back(st);
            } else {
                vector<string> temp{st};
                result.push_back(temp);
                add_index[s] = result.size();
            }
        }
        return result;
    }
    
    string hashAnagram(string a) {
        string hashStrA = "";
        if (hash[a] != "")
            hashStrA = hash[a];
        else {
            memset(charMapA, 0, sizeof charMapA);
            for (int i = 0; i < a.length(); i ++)
                charMapA[a[i] - 'a'] ++;
            for (int i = 0; i < 26; i ++) 
                hashStrA += to_string(charMapA[i]) + ";";
            hash[a] = hashStrA;
        }
        return hashStrA;
    }
};
