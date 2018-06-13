class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List[] neighbors = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            neighbors[i] = new ArrayList<Integer>();
        }
        for (int[] edge : prerequisites) {
            int u = edge[1];
            int v = edge[0];
            indegree[v] += 1;
            neighbors[u].add(v);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];     // instead of using ArrayList (very hard to convert to int[])
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[count] = cur;
            count++;
            for (int i = 0; i < neighbors[cur].size(); i++) {
                int nei = (int) neighbors[cur].get(i);
                indegree[nei] -= 1;
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
        if (count == numCourses) {
            return result;
        }
        return new int[0];
    }
}
