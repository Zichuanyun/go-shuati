class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int start) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList(tmp));
        }
        else {
            for(int i = start; i < candidates.length; ++i) {
                tmp.add(candidates[i]);
                dfs(res, tmp, candidates, target - candidates[i], i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}