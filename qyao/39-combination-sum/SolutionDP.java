class Solution {
  /*
   * Idea: Dynamic programming. Overlapping subproblems are "the solution set for target = n" And we could add each candidate to the solution set to get a solution for target + candidate. Iterate until we have found all solutions for target = target.
   * The List<Integer> represents "the count of each candidates", therefore starting off as all 0 (for target = 0)
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    HashMap<Integer, Set<List<Integer>>> solutionSetForTarget = new HashMap<>();
    Set<List<Integer>> solutionSetForZero = new HashSet<>();
    solutionSetForZero.add(new ArrayList<>(Collections.nCopies(candidates.length, 0)));
    solutionSetForTarget.put(0, solutionSetForZero);

    // we don't need add more candidates to the solution set when it already sums to the target
    for (int currentTarget = 0; currentTarget < target; currentTarget++) {
      if (!solutionSetForTarget.containsKey(currentTarget)) {
        continue;
      }

      for (int candidateIndex = 0; candidateIndex < candidates.length; candidateIndex++) {
        // creating a new solution set with that candidate count incremented
        Set<List<Integer>> newSolutionSet = new HashSet<>();
        for (List<Integer> solution : solutionSetForTarget.get(currentTarget)) {
          int originalCount = solution.get(candidateIndex);
          ArrayList<Integer> newSolution = new ArrayList<>(solution);
          newSolution.set(
              candidateIndex, originalCount + 1); // adding one of that candidate to the solution
          newSolutionSet.add(new ArrayList<>(newSolution));
        }

        int newTarget = currentTarget + candidates[candidateIndex];

        // append the new solutions to the new target solution set
        if (solutionSetForTarget.containsKey(newTarget)) {
          for (List<Integer> solution : newSolutionSet) {
            boolean ret = solutionSetForTarget.get(newTarget).add(solution);
          }
        } else {
          solutionSetForTarget.put(newTarget, newSolutionSet);
        }
      }
    }

    // convert our solution representation to the required format (count -> multiset)
    List<List<Integer>> targetSolutions = new ArrayList<>();
    if (!solutionSetForTarget.containsKey(target)) {
      return targetSolutions;
    } else {
      for (List<Integer> solution : solutionSetForTarget.get(target)) {
        List<Integer> aSolution = new ArrayList<>();
        for (int countIndex = 0; countIndex < solution.size(); countIndex++) {
          for (int count = 0; count < solution.get(countIndex); count++) {
            aSolution.add(candidates[countIndex]);
          }
        }
        targetSolutions.add(aSolution);
      }

      return targetSolutions;
    }
  }
}
