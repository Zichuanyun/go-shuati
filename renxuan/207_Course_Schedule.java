class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
        int[] map = new int[numCourses];
        int[][] edges = new int[numCourses][numCourses];
        for(int[] pre : prerequisites) {
            ++map[pre[0]];
            edges[pre[1]][pre[0]] = 1;
        }
        int course = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int key = 0; key < numCourses; ++key) {
            if(map[key] == 0) {
                q.offer(key);
                ++course;
            }
        }
        while(!q.isEmpty()) {
            int finished = q.poll();
            for(int i = 0; i < numCourses; ++i) {
                if(edges[finished][i] != 0) {
                    --map[i];
                    if(map[i] == 0) {
                        q.offer(i);
                        ++course;
                    }
                }
            }            
        }
        return course == numCourses;
    }
}