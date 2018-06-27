public class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
     
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] totalDist = new int[m][n];
        int buildings = 0;
        int[][] count = new int[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] != 1) continue;
                ++buildings;
                Queue<int[]> q = new LinkedList<>();
                boolean[][] visited = new boolean[m][n];
                q.offer(new int[]{i, j, 0});
                while(!q.isEmpty()) {
                    int[] curr = q.poll();
                    for(int[] dir : dirs) {
                        int r = curr[0] + dir[0], c = curr[1] + dir[1];
                        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != 0 || visited[r][c])
                            continue;
                        totalDist[r][c] += curr[2] + 1;
                        ++count[r][c];
                        q.offer(new int[]{r, c, curr[2] + 1});
                        visited[r][c] = true;
                    }
                }
            }
        }
        
        int res = Integer.MAX_VALUE; 
        for(int i = 0; i < m; ++i)
            for(int j = 0; j < n; ++j)
                if(grid[i][j] == 0 && count[i][j] == buildings) 
                    res = Math.min(res, totalDist[i][j]);
                    
        return res;
    }
}
