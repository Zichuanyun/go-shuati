class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int box = 0;
        int neighbor = 0;
        for(int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    box ++;
                    if(i < m - 1 && grid[i + 1][j] == 1)  neighbor++;
                    if(j < n - 1 && grid[i][j + 1] == 1)  neighbor++;
                }
            }
        }
        return box * 4 - neighbor * 2;
    }
}