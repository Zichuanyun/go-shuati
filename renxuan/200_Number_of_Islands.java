class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int islands = m * n;
        int[] union = new int[m * n];
        Arrays.fill(union, -1);
        for(int r = 0; r < m; ++r) {
            for(int c = 0; c < n; ++c) {
                if(grid[r][c] != '1') {
                    --islands;
                    continue;
                }
                for(int[] dir : dirs) {
                    int nextR = r + dir[0], nextC = c + dir[1];
                    if(nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || grid[nextR][nextC] != '1')
                        continue;
                    int curr = r * n + c, next = nextR * n + nextC;
                    while(union[curr] != -1) curr = union[curr];
                    while(union[next] != -1) next = union[next];
                    if(curr == next) continue;
                    union[next] = curr;
                    --islands;
                }
            }
        }
        return islands;
    }
}