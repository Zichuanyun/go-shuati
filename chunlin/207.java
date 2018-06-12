class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List[] neighbors = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            neighbors[i] = new ArrayList<Integer>();
        }
        for (int[] edge: prerequisites) {
            int u = edge[1];
            int v = edge[0];
            neighbors[u].add(v);
            indegree[v] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            count++;
            // for (Integer neighbor : neighbors[cur])    ----> Object cannot be converted to Integer
            for (int i = 0; i < neighbors[cur].size(); i++) {
                int nei = (int) neighbors[cur].get(i);
                indegree[nei] -= 1;     // forgot
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
        
        return numCourses == count;
        
        
    }
}
