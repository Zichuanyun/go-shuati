class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // corner case
        if (nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }
    
    private void dfs(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
        for (int i = start; i < nums.length; ++i) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfs(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }
}