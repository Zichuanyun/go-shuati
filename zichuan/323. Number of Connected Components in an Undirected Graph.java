class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] nodes = new int[n];
        for (int i = 0; i < n ; ++i) {
            nodes[i] = i;
        }
        for (int i = 0; i < edges.length; ++i) {
            int x = unionFind(nodes, edges[i][0]);
            int y = unionFind(nodes, edges[i][1]);
            if (x != y) {
                --n;
                nodes[y] = x;
            }
        }
        return n;
    }
    
    private int unionFind(int[] nodes, int i) {
        while (nodes[i] != i) {
            nodes[i] = nodes[nodes[i]];
            i = nodes[i];
        }
        return i;
    }
}