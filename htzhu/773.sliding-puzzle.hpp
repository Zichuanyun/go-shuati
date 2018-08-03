int m = 2, n = 3;
int offset = 3;
class Solution {
    int dirs[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    struct board_hash {
        size_t operator() (const vector<vector<int>> &b) const {
            size_t val = 0;
            for(int i = 0; i < m; i++)
                for(int j = 0; j < n; j++)
                    val |= (b[i][j] << ((i * n + j) * offset));
            return val;
        }
    };
public:
    int slidingPuzzle(vector<vector<int>>& board) {
        vector<vector<int>> dst = {{1, 2, 3}, {4, 5, 0}};
        if(board == dst) return 0;
        vector<pair<vector<vector<int>>, pair<int, int>>> lvl, tlvl;
        unordered_set<vector<vector<int>>, board_hash> vis;
        vis.insert(board);
        lvl.emplace_back(board, findZero(board));
        int k = 0;
        while(!lvl.empty()) {
            k++;
            tlvl.clear();
            for(auto &pr: lvl) {
                auto &b = pr.first;
                auto &zeroPos = pr.second;
                int r = zeroPos.first, c = zeroPos.second;
                for(int *dir: dirs) {
                    int x = r + dir[0], y = c + dir[1];
                    if(x < 0 || x >= m || y < 0 || y >= n) continue;
                    swap(b[r][c], b[x][y]);
                    if(!vis.count(b)) {
                        if(b == dst) return k;
                        vis.insert(b);
                        tlvl.emplace_back(b, make_pair(x, y));
                    }
                    swap(b[x][y], b[r][c]);
                }
            }
            lvl.swap(tlvl);
        }
        return -1;
    }
    pair<int, int> findZero(vector<vector<int>> &board) {
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(board[i][j] == 0)
                    return {i, j};
        return {-1, -1};
    }
};
