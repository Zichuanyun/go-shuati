class Solution {
  /*
  * Backtracking. Viewing this as a constraint satisfaction problem, try adding candidates to the list until we exceed / reach the target, abandon the partial solutions and collect the correct solutions into a set.
  * With a sequence like this (for [2,3,6,7] summing to 7):
   []
   [2]
   [2, 2]
   [2, 2, 2]
   [2, 2, 2, 2]
   [2, 2, 2, 3]
   [2, 2, 2, 6]
   [2, 2, 2, 7]
   [2, 2, 3] (success)
   [2, 2, 6]
   [2, 2, 7]
   [2, 3]
   [2, 3, 3]
   [2, 3, 6]
   [2, 3, 7]
   [2, 6]
   [2, 7]
   [3]
   ...
  */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> results = new ArrayList<>();
    Arrays.sort(candidates); // ensures the candidates comes in increasing order
    backtrack(results, new ArrayList<>(), candidates, target, 0);
    return results;
  }

  private void backtrack(
      List<List<Integer>> results,
      List<Integer> temporaryList,
      int[] candidates,
      int remain,
      int startCandidateIndex) {
    // if we have exceeded the target, abandon and backtrack
    if (remain < 0) {
      return;
    }
    // if we have just reached the target, store the list and backtrack
    else if (remain == 0) {
      results.add(new ArrayList<>(temporaryList));
      return;
    } else {
      // if we still haven't reached the target, continue building with the next candidate
      for (int i = startCandidateIndex; i < candidates.length; i++) {
        // incrementally build
        temporaryList.add(candidates[i]);
        // not startCandidateIndex + 1 because we can reuse the same element
        backtrack(results, temporaryList, candidates, remain - candidates[i], i);
        // remove the last element
        temporaryList.remove(temporaryList.size() - 1);
      }
      return;
    }
  }
}
