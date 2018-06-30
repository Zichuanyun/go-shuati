class Solution {
    public int calculate(String string) {
        int res = 0, num = 0, sign = 1;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            else if(c == '+' || c == '-') {
                res += sign * num;
                num = 0;
                sign = (c == '+')? 1 : -1;
            }
            else if(c == '(') {
                s.push(res);
                s.push(sign);
                res = 0;
                num = 0;
                sign = 1;
            }
            else if(c == ')') {
                res += sign * num;
                res = s.pop() * res + s.pop(); 
                num = 0;
            }
        }
        if(num != 0) res += sign * num;
        return res;
    }
}
