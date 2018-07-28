class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        n = grid.size();
        if (n == 0)
            return 0;
        m = grid[0].size();
        bool visited[n * m];
        memset(visited, 0, sizeof visited);
        cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (!visited[i * m + j] && grid[i][j] == '1') {
                    // printf("%d %d; ", i, j);
                    cnt++;
                    expand_from(i, j, grid, visited);
                }
            }
        return cnt;
    }
    
private:
    int n, m;
    int cnt;
    
    int deltax[4] = {0, -1, 0, 1};
    int deltay[4] = {1, 0, -1, 0};
    
    void expand_from(int x, int y, vector<vector<char>>& grid, bool visited[]) {
        visited[x * m + y] = true;
        for (int k = 0; k < 4; k++) {
            int newx = x + deltax[k];
            int newy = y + deltay[k];
            if (newx >= 0 && newx < n && newy >= 0 && newy < m) {
                if (grid[newx][newy] == '1' && !visited[newx * m + newy])
                    expand_from(newx, newy, grid, visited);
            }
        }
    }
};
