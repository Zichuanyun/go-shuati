class Solution {
    public int countComponents(int n, int[][] edges) {
    	int res = n;
    	int[] union = new int[n];
    	for(int i = 0; i < n; ++i)
    		union[i] = i;
    	for(int[] edge : edges) {
    		int src = edge[0], dst = edge[1];
    		while(union[src] != src) {
    			union[src] = union[union[src]];
    			src = union[src];
    		}
    		while(union[dst] != dst) {
    			union[dst] = union[union[dst]];
    			dst = union[dst];
    		}
    		if(src != dst) {
    			union[dst] = src;
    			--res;
    		}
    	}
    	return res;
    }
}