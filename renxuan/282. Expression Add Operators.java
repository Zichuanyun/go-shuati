class Solution {
    String num;
    int target;
    
    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        List<String> res = new ArrayList<>();
        if(num != null && num.length() > 0)
            dfs(res, "", 0, 0, 0);
        return res;
    }
    
    private void dfs(List<String> res, String path, int start, long sum, long mul) {
        if(start == num.length()) {
            if(sum == target) {
                res.add(path);
                return;
            }
        }
        for(int i = start; i < num.length(); ++i) {
            if(i != start && num.charAt(start) == '0') return;
            Long cur = Long.valueOf(num.substring(start, i + 1));
            if(start == 0) dfs(res, path + cur, i + 1, cur, cur);
            else {
                dfs(res, path + "+" + cur, i + 1, sum + cur, cur);
                dfs(res, path + "-" + cur, i + 1, sum - cur, -cur);
                dfs(res, path + "*" + cur, i + 1, sum - mul + mul * cur, mul * cur);
            }
        }
    }
}
