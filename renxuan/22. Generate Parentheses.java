class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }
    
    private void helper(List<String> res, String s, int open, int close, int n) {
        if(open + close == 2 * n) {
            res.add(s);
            return;
        }
        if(open < n) {
            helper(res, s + "(", open + 1, close, n);
        }
        if(open > close) {
            helper(res, s + ")", open, close + 1, n);
        }
    }
}
