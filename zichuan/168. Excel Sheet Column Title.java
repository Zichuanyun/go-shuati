class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder("");
        while (n > 0) {
            int a = n / 26;
            int b = n % 26;
            if (b == 0) {
                sb.insert(0, 'Z');
                --a;
            } else {
                sb.insert(0, Character.toString((char)('A' + b - 1)));
            }
            n = a;
        }
        return sb.toString();
    }
}