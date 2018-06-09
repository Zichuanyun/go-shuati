class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null) {
			return null;
		}
        Arrays.sort(candidates);
        List<Integer> combo = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, combo, res, 0);
        return res;       
    }
    public void helper (int[] candidates, int target, List<Integer> combo, List<List<Integer>> res, int ind) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(combo));
            return;
        } else if (target < 0) {
            return;
        } else{
            for (int i = ind; i < candidates.length; i++) {
                if(i > ind && candidates[i] == candidates[i-1]) continue;
                combo.add(candidates[i]);
                helper(candidates, target - candidates[i], combo, res, i+1);
                combo.remove(combo.size() - 1);
            }
        }
    }
}  