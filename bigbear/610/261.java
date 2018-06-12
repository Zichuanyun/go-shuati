class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visit = new boolean[n];
        
        ArrayList[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList();
        }
        
        for(int i = 0; i < edges.length; i++){
            int before = edges[i][1];
            int after = edges[i][0];
            graph[before].add(after);
        }
        
        for(int i = 0; i < n; i++){
            if(!dfs(-1, i, visit, graph)){
                return false;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(visit[i]) return false;
        }
        return true;
    }
    
    private boolean dfs(int parent, int count, boolean[] visit, ArrayList[] graph){
        visit[count] = true;
        for(int i= 0; i < graph[count].size(); i++){
            int next = (int)graph[count].get(i);
            if(next == parent) continue;
            if(visit[next]) return false;
            if(!dfs(count, next, visit, graph)){
                return false;
            }
        }
        visit[count] = false;
        return true;
    }
}