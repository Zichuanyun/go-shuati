class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int res = 0;
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[0].length; ++j) {
                if(grid[i][j] == 1)
                    res += countOneCell(grid, i, j);
            }
        }
        return res;
    }
    
    private int countOneCell(int[][] grid, int row, int col) {
        int res = 0;
        if(row == 0 || grid[row - 1][col] == 0) ++res;
        if(row == grid.length - 1 || grid[row + 1][col] == 0) ++res;
        if(col == 0 || grid[row][col - 1] == 0) ++res;
        if(col == grid[0].length - 1 || grid[row][col + 1] == 0) ++res;
        return res;
    }
}