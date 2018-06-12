class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        if(candidates.length == 0) return result;
        combinationSum(candidates, new LinkedList<Integer>(), result, target, 0);
        return result;
    }
    
    private void combinationSum(int[] candidates, LinkedList<Integer> cur, List<List<Integer>> result, int target, int begin){
        if(target == 0){
            result.add(new ArrayList<>(cur));
            return;
        }
        for(int i = begin; i < candidates.length && candidates[i] <= target; i++){
            cur.add(candidates[i]);
            combinationSum(candidates, cur, result, target - candidates[i], i);
            cur.removeLast();
        }
    }
}
