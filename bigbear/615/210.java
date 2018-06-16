class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
//               ArrayList<Integer>[] graph = new ArrayList[numCourses];
//         int[] indgree = new int[numCourses];
//         Queue<Integer> queue = new LinkedList<>();
        
//         for(int i = 0; i < numCourses; i++){
//             graph[i] = new ArrayList();
//         }
        
//         for(int j = 0; j < prerequisites.length; j++){
//             graph[prerequisites[j][1]].add(prerequisites[j][0]);
//             indgree[prerequisites[j][0]]++;
//         }
        
//         for(int k = 0; k < numCourses; k++){
//             if(indgree[k] == 0){
//                 queue.offer(k);
//             }
//         }
//         int[] order = new int[numCourses];
//         int z = 0;
//         while(!queue.isEmpty()){
//             int course = queue.poll();
//             order[z] = course;
//             z++;
//             for(int i = 0; i < graph[course].size(); i++){
//                 if(--indgree[graph[course].get(i)] == 0) queue.offer(graph[course].get(i));
//             }
//         }
        
//         return z == numCourses ? order: new int[0];
        
        
        int[] indegree = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList();
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            int before = prerequisites[i][1];
            int totake = prerequisites[i][0];
            graph[before].add(totake);
            indegree[totake]++;
        }
        
        Queue<Integer> q = new LinkedList();
        
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        
        int[] res = new int[numCourses];
        int pointer = 0;
        
        while(!q.isEmpty()){
            int course = q.poll();
            res[pointer++] = course;
            
            for(int i = 0; i < graph[course].size(); i++){
                 int next = (int)graph[course].get(i);
                if(--indegree[next] == 0){
                    q.offer(next);
                }
            }
        }
        return pointer == numCourses ? res: new int[0];
        
    }
}