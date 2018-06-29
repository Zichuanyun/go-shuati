struct Node {
    int r, c, d;
    string s;
    Node() {}
    Node(int r, int c, int d, const string &s):r(r), c(c), d(d), s(s) {}
    bool operator < (const Node &node) const {
        return d > node.d;
    }
};

class Solution {
    const int dirs[4][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    const string dirName[4] = {"r", "l", "u", "d"};
public:
    string findShortestWay(vector<vector<int>>& maze, vector<int>& ball, vector<int>& hole) {
        int m = maze.size(), n = maze[0].size();
        vector<vector<int>> dis(m, vector<int>(n, -1));
        vector<vector<string>> path(m, vector<string>(n));
        priority_queue<Node> pq;
        pq.emplace(ball[0], ball[1], 0, "");
        dis[ball[0]][ball[1]] = 0;
        while(!pq.empty()) {
            auto node = pq.top(); pq.pop();
            for(int i = 0; i < 4; i++) {
                auto dir = dirs[i];
                int r = node.r, c = node.c, d = node.d;
                auto newS = node.s + dirName[i];
                while(r >= 0 && r < m && c >= 0 && c < n
                      && maze[r][c] != 1 && !(r == hole[0] && c == hole[1])) {
                    r += dir[0];
                    c += dir[1];
                    d++;
                }
                bool isHole = (r == hole[0] && c == hole[1]);
                if(!isHole) {
                    r -= dir[0];
                    c -= dir[1];
                    d--;
                }
                if(dis[r][c] == -1 || d < dis[r][c] || d == dis[r][c] && newS < path[r][c]) {
                    dis[r][c] = d;
                    path[r][c] = newS;
                    if(!isHole) {
                        pq.emplace(r, c, d, node.s + dirName[i]);
                    }
                }
            }
        }
        return dis[hole[0]][hole[1]] == -1 ? "impossible" : path[hole[0]][hole[1]];
    }
};
