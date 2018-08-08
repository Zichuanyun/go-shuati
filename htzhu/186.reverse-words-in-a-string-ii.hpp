class Solution {
public:
    void reverseWords(vector<char>& str) {
        int n = str.size();
        reverse(str.begin(), str.end());
        int i = 0;
        while(i < n && str[i] == ' ') i++;
        int j = i;
        while(i < n) {
            while(j < n && str[j] != ' ') j++;
            reverse(str.begin() + i, str.begin() + j);
            j++;
            i = j;
        }
    }
};
