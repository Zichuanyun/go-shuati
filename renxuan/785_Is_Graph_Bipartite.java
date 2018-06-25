class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; ++i) {
            if(color[i] != 0) continue;
            color[i] = 1;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            while(!q.isEmpty()) {
                int current = q.poll();
                for(int neighbor : graph[current]) {
                    if(color[neighbor] == 0) {
                        color[neighbor] = (color[current] == 1) ? 2 : 1;
                        q.offer(neighbor);
                    } 
                    else if (color[neighbor] == color[current]) 
                        return false;
                }
            }
        }
        return true;
    }
}
