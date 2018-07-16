class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0, carry = 0;
        while (x < a.length() || y < b.length()) {
            int num_a = 0, num_b = 0;
            if (x < a.length()) {
                num_a = a.charAt(a.length() - 1 - x) - '0';
                ++x;
            }
            if (y < b.length()) {
                num_b = b.charAt(b.length() - 1 - y) - '0';
                ++y;
            }
            int res = num_a + num_b + carry;
            carry = 0;
            sb.insert(0, res % 2);
            if (res / 2 >= 1) {
                carry = 1;
            }
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}