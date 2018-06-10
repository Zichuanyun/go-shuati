class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
           return null;
        }
        Arrays.sort(candidates);
        List<Integer> combo = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, combo, res, 0);
        return res;
        
    }
    public void helper(int[] candidates, int target, 
                       List<Integer> combo, 
                       List<List<Integer>> res, int index) {
        if(target == 0) {
            res.add(new ArrayList<>(combo));
            return;
        }
        if (target < 0) {
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            combo.add(candidates[i]);
            helper(candidates, target - candidates[i], combo, res, i);
            combo.remove(combo.size() - 1);
        }
    }
}