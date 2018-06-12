class Solution {
    const int dirs[4][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        int m = maze.size(), n = maze[0].size();
        queue<vector<int>> q;
        if(start == destination) return true;
        q.push(start);
        while(!q.empty()) {
            auto u = q.front(); q.pop();
            maze[u[0]][u[1]] = -1;
            for(auto &dir: dirs) {
                auto v = u;
                vector<int> next;
                do {
                    next = v;
                    v[0] += dir[0];
                    v[1] += dir[1];
                } while(v[0] >= 0 && v[0] < m && v[1] >= 0 && v[1] < n && maze[v[0]][v[1]] != 1);
                if(next == destination) return true;
                if(maze[next[0]][next[1]] != -1) {
                    q.push(next);
                }
            }
        }
        return false;
    }
};
