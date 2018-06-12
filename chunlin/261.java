class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length !=  n - 1) {
            return false;
        }
        
        HashMap<Integer, HashSet<Integer>> neighbors = new HashMap<>();
        // init error, how to deal with 0 with no neighbors?
        for (int i = 0; i < n; i++) {
            neighbors.put(i, new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            // if (!neighbors.containsKey(edge[0])) {
            //     neighbors.put(edge[0], new HashSet<Integer>());
            // }
            // if (!neighbors.containsKey(edge[1])) {
            //     neighbors.put(edge[1], new HashSet<Integer>());
            // }
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> hash = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        hash.add(0);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (Integer neighbor: neighbors.get(cur)) {
                if (!hash.contains(neighbor)) {
                    queue.offer(neighbor);
                    hash.add(neighbor);
                }
            }
        }
        return hash.size() == n;
    }
}
