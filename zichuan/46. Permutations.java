class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new LinkedHashSet<Integer>());
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, LinkedHashSet<Integer> list) {
        // stop condition
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(nums, res, list);
                list.remove(nums[i]);
            }
        }
    }
}