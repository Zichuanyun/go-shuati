class Solution {
    const int dirs[4][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
public:
    int shortestDistance(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dis, cnt;
        dis = cnt = vector<vector<int>>(m, vector<int>(n));
        vector<vector<bool>> vis(m, vector<bool>(n));
        int k = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == 1) {
                    k++;
                    bfs({i, j}, grid, dis, vis, cnt);
                }
        int ans = INT_MAX;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == 0 && cnt[i][j] == k)
                    ans = min(ans, dis[i][j]);
        return ans == INT_MAX ? -1 : ans;
    }
    void bfs(pair<int, int> src, vector<vector<int>> &grid, vector<vector<int>> &dis, vector<vector<bool>> &vis, vector<vector<int>> &cnt) {
        int m = grid.size(), n = grid[0].size();
        for(auto &v: vis) fill(v.begin(), v.end(), false);
        vector<pair<int, int>> lvl, next;
        lvl.push_back(src);
        int d = 0;
        while(!lvl.empty()) {
            d++;
            next.clear();
            for(auto &pr: lvl) {
                for(auto dir: dirs) {
                    int x = pr.first + dir[0], y = pr.second + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && grid[x][y] == 0) {
                        dis[x][y] += d;
                        vis[x][y] = true;
                        cnt[x][y] ++;
                        next.push_back({x, y});
                    }
                }
            }
            lvl.swap(next);
        }
    }
};
