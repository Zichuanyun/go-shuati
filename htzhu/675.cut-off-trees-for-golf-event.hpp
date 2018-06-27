#define INF INT_MAX
struct Node {
    int r, c, h;
    Node() {}
    Node(int r, int c, int h): r(r), c(c), h(h) {}
    bool operator < (const Node &node) const {
        return h < node.h;
    }
};

class Solution {
    const int dirs[4][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
public:
    int cutOffTree(vector<vector<int>>& forest) {
        int m = forest.size(), n = forest[0].size();
        vector<Node> nodes;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(forest[i][j] > 0)
                    nodes.emplace_back(i, j, forest[i][j]);
        sort(nodes.begin(), nodes.end());
        int ans = 0;
        vector<vector<bool>> vis(m, vector<bool>(n));
        for(int i = 0; i < nodes.size(); i++) {
            pair<int, int> src(i == 0 ? 0 : nodes[i-1].r, i == 0 ? 0 : nodes[i-1].c);
            pair<int, int> dst(nodes[i].r, nodes[i].c);
            int res = bfs(src, dst, forest, vis);
            if(res < 0) return -1;
            ans += res;
        }
        return ans;
    }
    int bfs(const pair<int, int> &src, const pair<int, int> &dst, vector<vector<int>> &forest, vector<vector<bool>> &vis) {
        if(src == dst) return 0;
        int m = forest.size(), n = forest[0].size();
        for(auto &v: vis) fill(v.begin(), v.end(), false);
        vector<pair<int, int>> lvl, next;
        lvl.push_back(src);
        vis[src.first][src.second] = true;
        int d = 0;
        while(!lvl.empty()) {
            d++;
            next.clear();
            for(auto &pr: lvl) {
                for(auto dir: dirs) {
                    int x = pr.first + dir[0], y = pr.second + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && forest[x][y] > 0) {
                        if(dst.first == x && dst.second == y) return d;
                        vis[x][y] = true;
                        next.emplace_back(x, y);
                    }
                }
            }
            lvl.swap(next);
        }
        return -1;
    }
};
