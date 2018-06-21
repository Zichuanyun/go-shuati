class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums == null || nums.length == 0)   return rst;
        dfs(nums, rst, new ArrayList<Integer>());
        return rst;
    }
    
    public void dfs(int[] nums, List<List<Integer>> rst, List<Integer> list) {
        if (list.size() == nums.length) {
            rst.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                dfs(nums, rst, list);
                list.remove(list.size() - 1);
            }
        }
    }
}