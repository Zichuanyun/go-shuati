class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //corner case
        if(numCourses <= 0 || prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
        ArrayList<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<Integer>());
        }
        
        int[] inDegree = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++) {
            // 入度，即：有多少东西进来、指向我
            inDegree[prerequisites[i][0]]++;
            int pre = prerequisites[i][1];
            int ready = prerequisites[i][0];
            graph.get(pre).add(ready);
        }
        
        Queue<Integer> queue = new ArrayDeque<Integer>();
        
        for(int i = 0; i < inDegree.length; i++) {
            // 把所有不需要pre的课程加到队列中去
            if(inDegree[i] == 0)
                queue.offer(i);
        }
        
        int count = 0;
        while(queue.size() > 0) {
            int cur = queue.poll();
            // poll出来一门，就意味着完成了一门
            count++;
            for(Integer next : graph.get(cur)) {
                // 同时意味着需要cur作为pre的课程的入度由于pre的完成都减少了1
                // 即：指向我的东西变少了
                inDegree[next]--;
                if(inDegree[next] == 0)
                    queue.offer(next);
            }
        }
        // 最后返回是否所有的课都能完成
        return count == numCourses;
    }
}