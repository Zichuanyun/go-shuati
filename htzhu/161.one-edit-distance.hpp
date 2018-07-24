class Solution {
public:
    bool isOneEditDistance(string s, string t) {
        int m = s.size(), n = t.size();
        if(m > n) {
            s.swap(t);
            swap(m, n);
        }
        if(m == 0) return n == 1;
        int diff = n - m;
        if(diff > 1) return false;
        else {
            int i = 0, j = 0;
            for(; i < m && s[i] == t[j]; i++, j++);
            if(i == m && diff == 0) return false;
            if(diff == 0) return s.substr(i + 1) == t.substr(j + 1);
            else return s.substr(i) == t.substr(j + 1);
        }
        return true;
    }
};
