class Solution {
    const int dirs[4][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
public:
    int numIslands(vector<vector<char>>& grid) {
        if(grid.empty() || grid[0].empty()) return 0;
        int m = grid.size(), n = grid[0].size();
        int ans = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    ans++;
                    dfs(i, j, grid);
                }
            }
        return ans;
    }
    void dfs(int r, int c, vector<vector<char>>& grid) {
        int m = grid.size(), n = grid[0].size();
        grid[r][c] = 0;
        for(auto dir: dirs) {
            int x = r + dir[0], y = c + dir[1];
            if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1')
                dfs(x, y, grid);
        }
    }
};
