class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        if(nums == null || nums.length == 0) return result;
        List<Integer> temp = new LinkedList<>();
        backtrack(result, temp, 0, nums);
        return result;       
    }
    public void backtrack(List<List<Integer>> result, List<Integer> temp, int start, int[] nums) {
        result.add(new LinkedList<>(temp));
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            backtrack(result, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }
}