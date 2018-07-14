class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<ArrayList<Integer>>();
        process(res, new ArrayList<>(), 0, nums);
        return res;
    }
    
    public void process(List<List<Integer>> res, List<Integer> curList, int start_idx, int[] nums) {
        res.add(new ArrayList<Integer>(curList));
        for(int i = start_idx; i < nums.length; i++) {
            curList.add(nums[i]);
            process(res, curList, i + 1, nums);
            curList.remove(curList.size() - 1);
        }
    }
}