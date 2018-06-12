public class Solution {
    
    public boolean validTree(int n, int[][] edges) {
        int[] link = new int[n];
        Arrays.fill(link, -1);
        for(int i = 0; i < edges.length; i++){
            int start = find(edges[i][0], link);
            int end = find(edges[i][1], link);
            if(start == end) {
                return false;
            } 
           link[start] = end;
           
        }
        return edges.length == n - 1;
    }
    public int find(int i, int[] link) {
        if(link[i] != -1) {
            return find(link[i], link);
        } return i;
    }
}