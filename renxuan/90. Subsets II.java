class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrace(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    private void backtrace(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
        res.add(new ArrayList<>(tmp));
        for(int i = start; i < nums.length; ++i) {
            if(i != start && nums[i] == nums[i - 1]) continue;
            tmp.add(nums[i]);
            backtrace(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
