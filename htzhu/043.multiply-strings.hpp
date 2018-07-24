class Solution {
public:
    string multiply(string num1, string num2) {
        int m = num1.size(), n = num2.size();
        vector<int> ans(m + n);
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                ans[i+j+1] += (num1[i] - '0') * (num2[j] - '0');
        for(int i = m + n - 1; i > 0; i--) {
            ans[i-1] += ans[i] / 10;
            ans[i] %= 10;
        }
        string s;
        int i = 0;
        while(i < m + n && ans[i] == 0) i++;
        for(; i < m + n; i++) {
            s.push_back(ans[i] + '0');
        }
        return s.empty() ? "0" : s;
    }
};
