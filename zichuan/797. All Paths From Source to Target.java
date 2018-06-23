class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(res, list, graph);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> list, int[][] graph) {
        // stop condition
        int node = list.get(list.size() - 1);
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int child : graph[node]) {
            list.add(child);
            dfs(res, list, graph);
            list.remove(list.size() - 1);
        }
        
    }
}