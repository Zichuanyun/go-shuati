class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        dfs(nums, target, res, list, 0);
        
        return res;
        
    }
    
    private void dfs(int[] nums, int remain, List<List<Integer>> res, List<Integer> list, int start) {
        if (remain == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        if (remain < 0) {
            return;
        }
        
        // if (start >= nums.length) {
        //     return;
        // }
        
        for (int i = start; i < nums.length; ++i) {
            list.add(nums[i]);
            dfs(nums, remain - nums[i], res, list, i);
            list.remove(list.size() - 1);
        }
    }
}