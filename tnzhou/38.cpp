class Solution {
public:
    string countAndSay(int n) {
        string result = "1";
        for (int i = 1; i < n; i ++) {
            int cnt = 0;
            char cur = 0;
            string temp = "";
            for (char c:result) {
                if (c == cur) {
                    cnt += 1;
                } else {
                    if (cnt != 0) {
                        temp += to_string(cnt) + cur;
                    }
                    cur = c;
                    cnt = 1;
                }
            }
            if (cnt != 0) {
                temp += to_string(cnt) + cur;
            }
            result = temp;
        }
        return result;
    }
};
