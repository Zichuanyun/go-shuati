class Solution {
  /*
   * Recursive solution.
   * Recursive case: solution set is the union of the solution set of target - each candidate.
   * Base case: when target = 0, return an set with only a empty hashmap (candidate -> candidate count)
   * Another base case: when target is smaller than the smallest candidate, return empty set (because it's impossible)
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    Set<Map<Integer, Integer>> solutionSets = getSolutionSetForTarget(candidates, target);
    List<List<Integer>> solutions = new ArrayList<>();
    for (Map<Integer, Integer> solutionSet : solutionSets) {
      // convert the hashmap into a list
      List<Integer> solution = new ArrayList<>();
      for (Map.Entry<Integer, Integer> entry : solutionSet.entrySet()) {
        // add [key] * value
        for (int count = 0; count < entry.getValue(); count++) {
          solution.add(entry.getKey());
        }
      }
      solutions.add(solution);
    }

    return solutions;
  }

  private Set<Map<Integer, Integer>> getSolutionSetForTarget(int[] candidates, int target) {
    if (target == 0) {
      // when we have just reached the target, return an set with only a empty hashmap
      Set<Map<Integer, Integer>> solutionSet = new HashSet<>();
      HashMap<Integer, Integer> nothing = new HashMap<>();
      solutionSet.add(nothing);
      return solutionSet;
    } else if (target < candidates[0]) {
      // when the target is smaller than the smallest candidate, return empty set
      return new HashSet<>();
    } else {
      Set<Map<Integer, Integer>> solutionSet = new HashSet<>();
      for (int candidate : candidates) {
        Set<Map<Integer, Integer>> solutionSetForSubproblem =
            getSolutionSetForTarget(candidates, target - candidate);
        for (Map<Integer, Integer> solution : solutionSetForSubproblem) {
          int originalCount = solution.getOrDefault(candidate, 0);
          int updatedCount = originalCount + 1;
          solution.put(candidate, updatedCount);
          solutionSet.add(solution);
        }
      }
      return solutionSet;
    }
  }
}
