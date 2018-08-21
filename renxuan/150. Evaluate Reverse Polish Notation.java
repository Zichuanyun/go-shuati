class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String t : tokens) {
            if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int num2 = s.pop(), num1 = s.pop();
                switch(t) {
                    case "+":
                        s.push(num1 + num2);
                        break;
                    case "-":
                        s.push(num1 - num2);
                        break;
                    case "*":
                        s.push(num1 * num2);
                        break;
                    case "/":
                        s.push(num1 / num2);
                        break;
                }    
            }
            else s.push(Integer.valueOf(t));
        }
        return s.pop();
    }
}
