class Solution {
public:
    string addBinary(string a, string b) {
        string res = "";
        int ai = a.size() - 1;
        int bi = b.size() - 1;
        int incremental = 0;
        while (ai >= 0 && bi >= 0) {
            int curr = a[ai] - '0' + b[bi] - '0' + incremental;
            incremental = curr / 2;
            curr %= 2;
            res = to_string(curr) + res;
            ai --;
            bi --;
        }
        while (ai >= 0) {
            int curr = a[ai] - '0' + incremental;
            incremental = curr / 2;
            curr %= 2;
            res = to_string(curr) + res;
            ai --;
        }
        while (bi >= 0) {
            int curr = b[bi] - '0' + incremental;
            incremental = curr / 2;
            curr %= 2;
            res = to_string(curr) + res;
            bi --;
        }
        if (incremental == 1)
            res = '1' + res;
        if (res == "" && !a.empty() && !b.empty())
            res = "0";
        return res;
    }
};
