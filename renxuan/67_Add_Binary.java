class Solution {
    public String addBinary(String a, String b) {
        String res = "";
        int carry = 0;
        int n = Math.max(a.length(), b.length());
        for(int i=0; i<n; ++i) {
            int tmp = (a.length()>i? a.charAt(a.length()-1-i)-'0': 0)
                    + (b.length()>i? b.charAt(b.length()-1-i)-'0': 0)
                    + carry;
            if(tmp>=2) carry = 1;
            else carry = 0;
            res = (tmp%2==1? '1':'0') + res;
        }
        if(carry==1) res = '1' + res;
        return res;
    }
}
