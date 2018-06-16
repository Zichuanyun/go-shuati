class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int n = M.length;
        ArrayList<Integer>[] neighbors = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            neighbors[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    neighbors[i].add(j);
                    neighbors[j].add(i);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        int count = 0;
        while (!set.isEmpty()) {
            int cur = set.iterator().next();
            helper(cur, set, neighbors);
            count++;
        }
        return count;
    }
    
    private void helper(int cur, Set<Integer> set, ArrayList<Integer>[] neighbors) {
        set.remove(cur);
        for (int i = 0; i < neighbors[cur].size(); i++) {
            int nei = neighbors[cur].get(i);
            if (set.contains(nei)) {        // forgot to check, runtime error
                helper(nei, set, neighbors);
            }
        }
    }
}
