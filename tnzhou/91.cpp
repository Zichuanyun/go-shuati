class Solution {
public:
    int numDecodings(string s) {
        int n = s.length();
        if (n == 0)
            return 0;
        int f[n];
        memset(f, 0, sizeof f);
        f[0] = s[0] == '0' ? 0 : 1;
        if (n == 1)
            return f[0];
        if (s[1] != '0')
            f[1] += f[0];
        if (s[0] != '0' && (s[0] - '0') * 10 + s[1] - '0' <= 26)
            f[1] += 1;
        for (int i = 2; i < n; i++) {
            if (s[i] != '0')
                f[i] += f[i - 1];
            if (s[i - 1] != '0' && (s[i - 1] - '0') * 10 + s[i] - '0' <= 26)
                f[i] += f[i - 2];
        }
        return f[n - 1];
    }
};
