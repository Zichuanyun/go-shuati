class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<string> grid(n, string(n, '.'));
        vector<vector<string>> ans;
        dfs(0, grid, ans);
        return ans;
    }
    void dfs(int r, vector<string> &grid, vector<vector<string>> &ans) {
        int n = grid.size();
        if(r >= n) {
            ans.push_back(grid);
            return;
        }
        for(int c = 0; c < n; c++) {
            if(!check(r, c, grid)) continue;
            grid[r][c] = 'Q';
            dfs(r + 1, grid, ans);
            grid[r][c] = '.';
        }
    }
    bool check(int r, int c, vector<string> &grid) {
        int n = grid.size();
        for(int i = 0; i < r; i++)
            if(grid[i][c] == 'Q') return false;
        for(int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--)
            if(grid[i][j] == 'Q') return false;
        for(int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if(grid[i][j] == 'Q') return false;
        }
        return true;
    }
};
