class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, new boolean[nums.length], new ArrayList<>());
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, boolean[] visited, List<Integer> list) {
        // stop condition
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
            
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, res, visited, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}