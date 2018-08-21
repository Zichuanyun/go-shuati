class Solution {
public:
    string simplifyPath(string path) {
        deque<string> stk;
        int i = 0;
        while(i != string::npos) {
            int j = path.find('/', i + 1);
            int len = (j == string::npos ? path.size() : j) - i - 1;
            if(len > 0) {
                string s = path.substr(i + 1, len);
                if(s == "..") {
                    if(!stk.empty())
                        stk.pop_back();
                } else if(s != ".") {
                    stk.push_back(s);
                }
            }
            i = j;
        }
        string ans;
        while(!stk.empty()) {
            ans.push_back('/');
            ans += stk.front();
            stk.pop_front();
        }
        return ans.empty() ? "/" : ans;
    }
};
