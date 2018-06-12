class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {  
        int finished = 0;
        boolean[][] relation = new boolean[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            relation[prerequisites[i][0]][prerequisites[i][1]] = true;
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) {
                queue.offer(i);
                
            }
        }
        while(!queue.isEmpty()) {
            int course = queue.poll();
            finished ++;
            for(int i = 0; i < numCourses; i++) {
                if(relation[i][course] == true) {
                    indegree[i]--;
                  if(indegree[i] == 0) {
                    queue.offer(i);
                   }
                }              
            }           
        }
        if(finished == numCourses) {
            return true;
        } else{
            return false;
        }
    }     
}