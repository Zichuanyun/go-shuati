class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(candidates); // forgot
        List<List<Integer>> results = new ArrayList<>();
        helper(new ArrayList<Integer>(), results, target, 0, candidates);
        return results;
    }
    private void helper(List<Integer> list,
                       List<List<Integer>> results, 
                       int remain,
                       int startIndex,
                       int[] candidates) {
        if (remain == 0) {
            results.add(new ArrayList<Integer>(list));
            return; // forgot
        } // forgot
        for (int i = startIndex; i < candidates.length; i++) {
            int current = candidates[i];
            if (remain - current >= 0) {    // forgot
                list.add(current);
                helper(list, results, remain - current, i, candidates);
                list.remove(list.size() - 1); // list.length
            }
        }
    }
}
