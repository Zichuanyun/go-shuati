class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int index) {
        res.add(new ArrayList(tmp));
        for(int i = index; i < nums.length; ++i) {
            tmp.add(nums[i]);
            dfs(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
