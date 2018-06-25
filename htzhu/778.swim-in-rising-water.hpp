struct Node {
    int r, c, w;
    Node() {}
    Node(int r, int c, int w): r(r), c(c), w(w) {}
    bool operator < (const Node &node) const {
        return w > node.w;
    }
};

class Solution {
    const int dirs[4][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
public:
    int swimInWater(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<vector<int>> dis(n, vector<int>(n, -1));
        priority_queue<Node> pq;
        pq.push(Node(0, 0, grid[0][0]));
        dis[0][0] = grid[0][0];
        while(!pq.empty()) {
            auto node = pq.top(); pq.pop();
            for(auto dir: dirs) {
                int x = node.r + dir[0], y = node.c + dir[1];
                if(x >= 0 && x < n && y >= 0 && y < n) {
                    int d = max(node.w, grid[x][y]);
                    if(dis[x][y] == -1 || d < dis[x][y]) {
                        dis[x][y] = d;
                        pq.push(Node(x, y, d));
                    }
                }
            }
        }
        return dis[n-1][n-1];
    }
};
