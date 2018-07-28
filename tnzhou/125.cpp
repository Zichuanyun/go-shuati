class Solution {
public:
    bool isPalindrome(string s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < s.length() && !isalpha(s[l]) && !isdigit(s[l]))
                l++;
            while (r >= 0 && !isalpha(s[r]) && !isdigit(s[r])) 
                r--;
            if (l >= r)
                return true;
            if (tolower(s[l]) != tolower(s[r]))
                return false;
            l++;
            r--;
        }
        return true;
    }
};
