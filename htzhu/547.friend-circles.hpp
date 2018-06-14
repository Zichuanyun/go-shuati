class Solution {
    vector<int> id, sz;
    int cnt;
public:
    int findCircleNum(vector<vector<int>>& M) {
        int n = M.size();
        cnt = n;
        id = decltype(id)(n);
        iota(id.begin(), id.end(), 0);
        sz = decltype(sz)(n, 1);
        for(int i = 0; i < n; i++)
            for(int j = i; j < n; j++) {
                if(M[i][j]) {
                    connect(i, j);
                }
            }
        return cnt;
    }
    int find(int x) {
        return x == id[x] ? x : id[x] = find(id[x]);
    }
    void connect(int x, int y) {
        int p = find(x), q = find(y);
        if(p == q) return;
        if(sz[p] < sz[q]) swap(p, q);
        id[q] = p;
        sz[p] += sz[q];
        cnt--;
    }
};
