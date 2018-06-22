class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(rooms[i][j] == 0)
                    dfs(rooms, i, j, 0);
            }
        }
    }
    
    private void dfs(int[][] rooms, int row, int col, int step) {
        int m = rooms.length, n = rooms[0].length;
        if(row < 0 || row >= m || col < 0 || col >= n || rooms[row][col] < step)
            return;
        rooms[row][col] = step;
        dfs(rooms, row + 1, col, step + 1);
        dfs(rooms, row - 1, col, step + 1);
        dfs(rooms, row, col + 1, step + 1);
        dfs(rooms, row, col - 1, step + 1);
    }
}
