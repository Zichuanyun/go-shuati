#define INF INT_MAX
class Solution {
    const int dirs[4][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
public:
    void wallsAndGates(vector<vector<int>>& rooms) {
        if(rooms.empty() || rooms[0].empty()) return;
        int m = rooms.size(), n = rooms[0].size();
        queue<pair<int, int>> q;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(rooms[i][j] == 0)
                    q.push({i, j});
        int k = 0;
        while(!q.empty()) {
            k++;
            int sz = q.size();
            while(sz--) {
                auto pr = q.front(); q.pop();
                for(auto dir: dirs) {
                    int x = pr.first + dir[0], y = pr.second + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] == INF) {
                        rooms[x][y] = k;
                        q.push({x, y});
                    }
                }
            }
        }
    }
};
