class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if(m <= 0 || n <= 0 || positions == null) {
            return new ArrayList<Integer>();
        }
        int[][] dir = {{0,1}, {1,0}, {-1, 0}, {0, -1}};
        List<Integer> res = new ArrayList<>();
        int[] roots = new int[m * n];
        int count = 0;
        Arrays.fill(roots, -1);
        for(int i = 0; i < positions.length; i++) {
            int id = positions[i][0] * n + positions[i][1];
            roots[id] = id; // create its own island
            count++;
            //now look at neighbors
            for(int[] d : dir) {
                int idx = positions[i][0] + d[0];
                int idy = positions[i][1] + d[1];
                int nbID = idx * n + idy;
                if(idx < 0 || idx >= m || idy < 0 || idy >= n || roots[nbID] == -1) {
                    continue;
                }
                int rootN = findIsland(roots, nbID);
                if(id != rootN) {
                    roots[id] = rootN;
                    id = rootN;
                    count --;
                }
            }
            res.add(count);
            
        }
        return res;
    }
    public int findIsland(int[] roots, int id) {
        while(roots[id] != id) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}