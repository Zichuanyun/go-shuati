class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        int[] union = new int[n];
        Arrays.fill(union, -1);
        for(int[] edge : edges) {
            int v1 = edge[0], v2 = edge[1];
            while(union[v1] != -1) v1 = union[v1];
            while(union[v2] != -1) v2 = union[v2];
            if(v1 == v2) return false;
            union[v2] = v1;
        }
        return true;
    }
}