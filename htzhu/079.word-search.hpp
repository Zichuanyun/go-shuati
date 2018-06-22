class Solution {
    const int dirs[4][2] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
public:
    bool exist(vector<vector<char>>& board, string word) {
        if(word.empty()) return true;
        if(board.empty() || board[0].empty()) return false;
        int m = board.size(), n = board[0].size();
        vector<vector<bool>> vis(m, vector<bool>(n));
        string path;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) {
                path.push_back(board[i][j]);
                vis[i][j] = true;
                if(dfs(i, j, board, path, vis, word))
                    return true;
                path.pop_back();
                vis[i][j] = false;
            }
        return false;
    }
    bool dfs(int r, int c, vector<vector<char>>& board, string &path, vector<vector<bool>> &vis, string &word) {
        int p = path.size(), q = word.size();
        if(path[p-1] != word[p-1]) return false;
        if(p == q) return true;
        int m = board.size(), n = board[0].size();
        for(auto &dir: dirs) {
            int x = r + dir[0];
            int y = c + dir[1];
            if(x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
                vis[x][y] = true;
                path.push_back(board[x][y]);
                if(dfs(x, y, board, path, vis, word)) {
                    return true;
                }
                vis[x][y] = false;
                path.pop_back();
            }
        }
        return false;
    }
};
