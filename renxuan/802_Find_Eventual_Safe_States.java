class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int n = graph.length;
        Set<Integer>[] inNode = new Set[n];
        int[] outDegrees = new int[n];
        for(int i = 0; i < n; ++i) inNode[i] = new HashSet<>();
        for(int i = 0; i < n; ++i) {
            int[] neighbors = graph[i];
            for(int j : neighbors) {
                inNode[j].add(i);
                ++outDegrees[i];
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; ++i) {
            if(outDegrees[i] == 0) {
                res.add(i);
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            int top = q.poll();
            for(int i : inNode[top]) {
                if(--outDegrees[i] == 0) {
                    res.add(i);
                    q.offer(i);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
