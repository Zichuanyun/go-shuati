class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums == null || nums.length == 0)   return rst;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(rst, nums, new ArrayList<>(), used);
        return rst;
    }
    
    private void dfs(List<List<Integer>> rst, int[] nums, List<Integer> list, boolean[] used) {
        if(list.size() == nums.length) {
            rst.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            list.add(nums[i]);
            used[i] = true;
            dfs(rst, nums, list, used);
            list.remove(list.size() - 1);    
            used[i] = false;
            
        }
    }
}