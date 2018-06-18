class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; ++k) {
                        int x = i + dirs[k][0];
                        int y = j + dirs[k][1];
                        if (x < 0 || x == grid.length
                            || y < 0 || y == grid[0].length
                            || grid[x][y] == 0) {
                            ++count;
                        }
                    }
                }
            }
        }
        return count;
    }
    
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
}