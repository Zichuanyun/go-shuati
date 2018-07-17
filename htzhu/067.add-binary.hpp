class Solution {
public:
    string addBinary(string a, string b) {
        string ans;
        int carry = 0;
        int m = a.size(), n = b.size();
        for(int i = m - 1, j = n - 1; i >= 0 || j >= 0;) {
            int tmp = (i >= 0 ? a[i--] - '0' : 0) + (j >= 0 ? b[j--] - '0' : 0) + carry;
            if(tmp > 1) {
                tmp -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
            ans.push_back(tmp + '0');
        }
        if(carry) {
            ans.push_back('1');
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};
