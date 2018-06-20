class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] next = new int[n]; //store the to indexes
        int[] pre = new int [n]; //store the from indexes
        Arrays.fill(next,-1); 
        Arrays.fill(pre,-1);
        
        pre[src] = 0;
        for(int i = 0; i<=K; i++){ //while less than the num of inter-stops
            for(int[] f : flights){  //loop through flight array
                if(pre[f[0]] != -1){  //if we are at the src 
                    if(next[f[1]] == -1 || next[f[1]] > pre[f[0]]+f[2]){
                        next[f[1]] = pre[f[0]]+f[2]; //if to index can have a better value, store the new value
                    }
                }
            }
            System.arraycopy(next, 0, pre, 0,n); //copy next to pre
        }
        return next[dst];
    }
}