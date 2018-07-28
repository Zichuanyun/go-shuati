class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if (digits.length() ==0)
            return result;
        dict['2'] = vector<char> {'a', 'b', 'c'};
        dict['3'] = vector<char> {'d', 'e', 'f'};
        dict['4'] = vector<char> {'g', 'h', 'i'};
        dict['5'] = vector<char> {'j', 'k', 'l'};
        dict['6'] = vector<char> {'m', 'n', 'o'};
        dict['7'] = vector<char> {'p', 'q', 'r', 's'};
        dict['8'] = vector<char> {'t', 'u', 'v'};
        dict['9'] = vector<char> {'w', 'x', 'y', 'z'};
        dfs(digits, 0, "");
        return result;
    }
private:
    vector<string> result;
    unordered_map<int, vector<char>> dict;
    
    void dfs(string &digits, int idx, string curRes) {
        if (idx == digits.length())
            result.push_back(curRes);
        for (int i = 0; i < dict[digits[idx]].size(); i++) {
            dfs(digits, idx + 1, curRes + dict[digits[idx]][i]);
        }
    }
};
