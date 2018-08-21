class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.trim().split("/");
        Stack<String> stack = new Stack<>();
        for(String s : strs) {
            if(s.length() == 0 || s.equals(".")) continue;
            if(s.equals("..")) {
                if(!stack.empty()) stack.pop();
            }
            else stack.push(s);
        }
        String res = "";
        for(String s : stack) {
            res = res + "/" + s;
        }
        return res.length() == 0? "/" : res;
    }
}
