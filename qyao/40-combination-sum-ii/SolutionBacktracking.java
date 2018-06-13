class Solution {
  /*
   * Backtracking solution. As now there can be duplicate elements and we cannot reuse elements, the branching strategy would be deciding on which element on the right should we jump to.
   * No reuse -> can only move to the right.
   * Contains duplicate -> in [1, 1, 1, 4, 4, 4, 5], when we are at the first 1, we can jump to the second 1 but not the third 1 (because otherwise we would stop ourselves from getting multiple 1s in the solution at all. We can jump to the first 4 but not the second or the third 4. Because otherwise, if we 1. (0->3->6) select the first 4 while abandoning the other two 2. (0->4->6) abandon the first 4 and third 4 while choosing the second would emit the exact same result, which would give us duplicate solutions.
   */
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> results = new ArrayList<>();
    backtrack(results, new ArrayList<>(), candidates, target, 0);
    return results;
  }

  private void backtrack(
      List<List<Integer>> results,
      List<Integer> temporaryList,
      int[] candidates,
      int remain,
      int start) {
    if (remain < 0) {
      // this branch is impossible
      return;
    } else if (remain == 0) {
      // we have just arrived at target
      results.add(new ArrayList<>(temporaryList));
    } else {
      for (int i = start; i < candidates.length; i++) {
        if (i != start && candidates[i] == candidates[i - 1]) {
          // if this is not a immediate duplicate AND is not the beginning of a series of duplicate
          continue;
        }
        temporaryList.add(candidates[i]);
        backtrack(results, temporaryList, candidates, remain - candidates[i], i + 1);
        temporaryList.remove(temporaryList.size() - 1);
      }
    }
  }
}
