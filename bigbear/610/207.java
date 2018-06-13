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


DFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //dfs
        
        boolean[] visit = new boolean[numCourses];
        
        ArrayList[] graph = new ArrayList[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList();
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            int precondition = prerequisites[i][1];
            int tohave = prerequisites[i][0];
            
            graph[precondition].add(tohave);
        }
        
        for(int i = 0; i < numCourses; i++){
            if(!taken(i, graph, visit)){
                return false;
            }
        }
        return true;
    }
    
    private boolean taken(int course, ArrayList[] graph, boolean[] visit){
        if(visit[course]) return false;
        else  visit[course] = true;
        for(int i = 0; i < graph[course].size(); i++){
            int next = (int)graph[course].get(i);
            if(!taken(next, graph, visit)){
                return false;
            }
        }
        visit[course] = false;
        return true;
    }
}