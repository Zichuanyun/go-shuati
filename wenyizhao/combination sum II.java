class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        if(candidates.length == 0) return result;
        combinationSum(candidates, new LinkedList<Integer>(), result, target, 0, new HashSet<List<Integer>>());
        return result;
    }
    
    private void combinationSum(int[] candidates, LinkedList<Integer> cur, List<List<Integer>> result, int target, int begin, Set<List<Integer>> set){
        if(target == 0){
            if(!set.contains(cur)) {
                set.add(cur);
                result.add(new ArrayList<>(cur));
                return;
            }
        }
        for(int i = begin; i < candidates.length && candidates[i] <= target; i++){
            cur.add(candidates[i]);
            combinationSum(candidates, cur, result, target - candidates[i], i+1, set);
            cur.removeLast();
        }
    }
}
