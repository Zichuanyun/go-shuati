struct Node {
    int r, c, d;
    Node() {}
    Node(int r, int c, int d):r(r), c(c), d(d) {}
    bool operator < (const Node &node) const {
        return d > node.d;
    }
};

class Solution {
    const int dirs[4][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
public:
    int shortestDistance(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        int m = maze.size(), n = maze[0].size();
        vector<vector<int>> dis(m, vector<int>(n, -1));
        priority_queue<Node> pq;
        dis[start[0]][start[1]] = 0;
        pq.emplace(start[0], start[1], 0);
        while(!pq.empty()) {
            auto node = pq.top(); pq.pop();
            for(auto dir: dirs) {
                int r = node.r, c = node.c, d = node.d;
                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                    d++;
                }
                r -= dir[0];
                c -= dir[1];
                d--;
                if(r == destination[0] && c == destination[1]) return d;
                if(dis[r][c] == -1 || d < dis[r][c]) {
                    dis[r][c] = d;
                    pq.emplace(r, c, d);
                }
            }
        }
        return dis[destination[0]][destination[1]];
    }
};
