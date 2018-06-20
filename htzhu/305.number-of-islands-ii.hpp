class Solution {
    const int dirs[4][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    vector<int> id, sz;
    int cnt = 0;
    int m, n;
public:
    vector<int> numIslands2(int m, int n, vector<pair<int, int>>& positions) {
        this->m = m;
        this->n = n;
        sz = id = decltype(id)(m * n);
        int N = positions.size();
        vector<int> ans(N);
        for(int i = 0; i < N; i++) {
            auto &point = positions[i];
            int r = point.first, c = point.second;
            int index = p2id(r, c);
            id[index] = index;
            sz[index] = 1;
            cnt++;
            for(auto &dir: dirs) {
                int x = r + dir[0], y = c + dir[1];
                if(x >= 0 && x < m && y >= 0 && y < n) {
                    int newIndex = p2id(x, y);
                    if(sz[newIndex]) {
                        connect(index, newIndex);
                    }
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }
    int findp(int x) {
        return x == id[x] ? x : (id[x] = findp(id[x]));
    }
    void connect(int x, int y) {
        int p = findp(x), q = findp(y);
        if(p == q) return;
        if(sz[p] < sz[q]) swap(p, q);
        id[q] = p;
        sz[p] += sz[q];
        cnt--;
    }
    int p2id(int r, int c) {
        return r * n + c;
    }
};
