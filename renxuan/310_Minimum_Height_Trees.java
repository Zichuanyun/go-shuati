class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();       
        if (n == 1) {
            leaves.add(0);
            return leaves;
        }
        Set<Integer>[] edgeList = new Set[n];
        for (int i = 0; i < n; ++i) 
            edgeList[i] = new HashSet<>();
        for (int[] edge : edges) {
            edgeList[edge[0]].add(edge[1]);
            edgeList[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < n; ++i)
            if (edgeList[i].size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                for(int j : edgeList[i]) {
                    edgeList[j].remove(i);
                    if (edgeList[j].size() == 1) newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
