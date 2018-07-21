public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals(t)) return false;
        if(s.length() < t.length()) return isOneEditDistance(t, s);
        if(s.length() - t.length() > 1) return false;
        if(s.length() == t.length()) {
            int cnt = 0;
            for(int i = 0; i < s.length(); ++i) {
                if(s.charAt(i) != t.charAt(i)) {
                    if(cnt == 1) return false;
                    ++cnt;
                }
            }
            return true;
        }
        int cnt = 0;
        for(int i = 0, j = 0; j < t.length();) {
            if(s.charAt(i) != t.charAt(j)) {
                if(cnt == 1) return false;
                ++i;
                ++cnt;
            }
            else {
                ++i; ++j;
            }   
        }
        return true;
    }
}
