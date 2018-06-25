 List<List<Integer>> adjList = new ArrayList<>(n);
    
    //initialize vertices
    for(int  i = 0; i < n; i++){
        adjList.add(i, new ArrayList<Integer>());
    }
    
    //add edges
    for(int i = 0; i < edges.length; i++){
        int u = edges[i][0];
        int v = edges[i][1];
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    
    boolean[] visited = new boolean[n];
    
    //make sure there is no cycle
    if(hasCycle(adjList, 0, visited, -1)){
        return false;
    }
    
    //make sure all vertices are connected
    for(int i = 0; i < n; i++){
        if(!visited[i]){
            return false;
        }
    }
    return true;
}

//check if an undirected graph has cycle started from vertex u
boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited,int parent){
    visited[u] = true;
    
    for(int i = 0; i < adjList.get(u).size(); i++){
        int v = adjList.get(u).get(i);
        //if v is not parent of vertex and v is not visited
        if((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList,v,visited,u))){
            return true;
        }
    }
    return false;
}

