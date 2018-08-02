class Solution {
public:
    string multiply(string num1, string num2) {
        long long res[500];
        memset(res, 0, sizeof res);
        for (int i = 0; i < num2.size(); i++) {
            int idx2 = num2.size() - 1 - i;
            for (int j = 0; j < num1.size(); j++) {
                int idx1 = num1.size() - 1 - j;
                res[i + j] += (num2[idx2] - '0') * (num1[idx1] - '0');
            }
        }
        int acc = 0;
        for (int i = 0; i < 500; i ++) {
            res[i] += acc;
            acc = res[i] / 10;
            res[i] = res[i] % 10;
        }
        int idx = 499;
        string ans = "";
        while (idx > 0 && res[idx] == 0)
            idx--;
        for (int i = idx; i >= 0; i--) {
            ans += to_string(res[i]);
        }
        return ans;
    }
};
