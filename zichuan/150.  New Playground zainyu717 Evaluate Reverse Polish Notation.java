class Solution {
public int evalRPN(String[] tokens) {
       // corner case
       if (tokens == null || tokens.length < 1) {
            return 0;
        }

        len = tokens.length - 1;
        return helper(tokens);
    }

    private int len;

    private int helper(String[] tokens) {
        switch(tokens[len--]) {
            case "+" :
                return helper(tokens) + helper(tokens);
            case "-" :
                return -helper(tokens) + helper(tokens);
            case "*" :
                return helper(tokens) * helper(tokens);
            case "/" :
                return (int) (1.0 / helper(tokens) * helper(tokens));
            default :
                return Integer.valueOf(tokens[len + 1]);
        }
    }
}
