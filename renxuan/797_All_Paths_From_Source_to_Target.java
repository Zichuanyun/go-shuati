class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        int n = graph.length;
        Set<Integer>[] toNodes = new Set[n];
        for(int i = 0; i < n; ++i) {
            toNodes[i] = new HashSet<>();
            for(int j : graph[i])
                toNodes[i].add(j);
        }
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        curr.add(0);
        q.offer(curr);
        while(!q.isEmpty()) {
            curr = q.poll();
            int node = curr.get(curr.size() - 1);
            if(node == n - 1) {
                res.add(curr);
                continue;
            }
            for(int next : toNodes[node]) {
                curr.add(next);
                q.offer(new LinkedList(curr));
                curr.remove(curr.size() - 1);
            }
        }
        return res;
    }
}
