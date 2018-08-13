class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int n = s.length();
        for(int c = 0; c < n; ++c) {
            int l = c, r = c;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > res.length()) res = s.substring(l, r + 1);
                --l; ++r;
            }
            l = c; r = c + 1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > res.length()) res = s.substring(l, r + 1);
                --l; ++r;
            }
        }
        return res;
    }
}
