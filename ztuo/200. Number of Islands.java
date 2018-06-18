class Solution {
    
    public int numIslands(char[][] grid) {
        int numIsland = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numIsland ++;
                }
            }
        }
        return numIsland;
    }
    
    public void dfs(char[][] grid, int m, int n) {
        if(m < 0 || n < 0 || m >= grid.length || n >= grid[0].length || grid[m][n] == '0') {
            return;
        }
        if(grid[m][n] == '1'){
            grid[m][n] = '0';
            dfs(grid, m + 1, n);
            dfs(grid, m, n + 1);
            dfs(grid, m - 1, n);
            dfs(grid, m, n - 1);
        }        
    }
}