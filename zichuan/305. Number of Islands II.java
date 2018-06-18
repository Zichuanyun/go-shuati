class Solution {
    
    Map<Integer, Integer> map = new HashMap<>();
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[][] islands = new int[m][n];
        int counter = 0;
        int islandCount = 0;
        for (int[] pos : positions) {
            int x_pos = pos[0];
            int y_pos = pos[1];
            if (islands[x_pos][y_pos] != 0) continue;
            ++counter;
            islands[x_pos][y_pos] = counter;
            // must use set, because we have to update the islandCount
            Set<Integer> adj_distinct = new HashSet<>();
            for (int i = 0; i < 4; ++i) {
                int x = x_pos + dirs[i][0];
                int y = y_pos + dirs[i][1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (islands[x][y] != 0) {
                        adj_distinct.add(unionFind(islands[x][y]));
                    }
                }
            }
            
            if (adj_distinct.size() != 0) {
                // union again
                for (int i : adj_distinct) {
                    map.put(i, islands[x_pos][y_pos]);
                }
            }
            map.put(islands[x_pos][y_pos], islands[x_pos][y_pos]);
            islandCount += 1 - adj_distinct.size();
            res.add(islandCount);
        }
        return res;
    }
    
    // with path compression
    private int unionFind(int i) {
        while (i != map.get(i)) {
            map.put(i, map.get(map.get(i)));
            i = map.get(i);
        }
        return i;
    }
}