class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int n = 0; n < numCourses; n++) {
            if(inDegree[n] == 0) {
                queue.offer(n);
            }
        }
        int[] seq = new int[numCourses];
        int i = 0;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            seq[i++] = curr;
            if(graph[curr].size() > 0) {
                for(int n: graph[curr]) {
                    inDegree[n] --;
                    if(inDegree[n] == 0) {
                        queue.offer(n);
                    } else if (inDegree[n] < 0) {
                        return new int[0];
                    }
                }
            }
        }
        return i == numCourses ? seq : new int[0];
        
    }
}