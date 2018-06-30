public int calculate(String s) {
    int pre = 0, curr = 0, sign = 1, op = 0, num = 0;
    
    for (int i = 0; i < s.length(); i++) {
        if (Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {
                curr = (op == 0 ? num : (op == 1 ? curr * num : curr / num));
            }
            
        } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
            op = (s.charAt(i) == '*' ? 1 : -1);
            num = 0;
            
        } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            pre += sign * curr;
            sign = (s.charAt(i) == '+' ? 1 : -1);
            op = 0;
            num = 0;
        }
    }
    
    return pre + sign * curr;
}