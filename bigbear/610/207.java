class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //BFS solution
        
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < prerequisites.length; i++){
            int after = prerequisites[i][0];
            int before = prerequisites[i][1];
            matrix[before][after]++;
            indegree[after]++;
        }
        
        for(int i = 0; i < numCourses; ++i){
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int course = q.poll();
            count++;
            for(int i = 0; i < numCourses; ++i){
                    if(matrix[course][i] != 0){
                        
                        indegree[i]--;
                        if(indegree[i] == 0){
                            q.offer(i);
                        }
                    }
                }
            }
        return count == numCourses;
        }
}