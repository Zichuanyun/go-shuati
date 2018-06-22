class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums) {
        if(tmp.size() == nums.length) {
            res.add(new ArrayList(tmp));
            return;
        }
        for(int num : nums) {
            if(tmp.contains(num)) continue;
            tmp.add(num);
            dfs(res, tmp, nums);
            tmp.remove(tmp.size() - 1);
        }
    }
}
