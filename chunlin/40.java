class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        helper(candidates, results, new ArrayList<Integer>(), target, 0);
        return results;
    }
    private void helper(int[] candidates,
                       List<List<Integer>> results,
                       List<Integer> list,
                       int remain,
                       int startIndex) {
        if (remain == 0) {
            results.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) {    // i != 0 && !=
                continue;
            }
            
            if (remain - candidates[i] >= 0) {
                int cur = candidates[i];
                list.add(cur);
                helper(candidates, results, list, remain - cur, i + 1);    
                list.remove(list.size() - 1);
            }
        }
    }
}
