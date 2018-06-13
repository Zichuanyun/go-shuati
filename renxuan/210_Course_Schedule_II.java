class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] inDegree = new int[numCourses];
        int[][] edges = new int[numCourses][numCourses];
        for(int[] prerequisite : prerequisites) {
            ++inDegree[prerequisite[0]];
            edges[prerequisite[1]][prerequisite[0]] = 1;
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;        
        for(int course = 0; course < numCourses; ++course) {
            if(inDegree[course] == 0) {
                q.offer(course);
                res[count++] = course;
            }
        }
        while(!q.isEmpty()) {
            int finished = q.poll();
            for(int course = 0; course < numCourses; ++course) {
                if(edges[finished][course] == 1) {
                    if(--inDegree[course] == 0) {
                        q.offer(course);
                        res[count++] = course;
                    }
                }
            }
        }
        
        return count == numCourses? res : new int[0];
    }
}