class Solution {
    vector<int> id, sz;
    int cnt;
public:
    int countComponents(int n, vector<pair<int, int>>& edges) {
        cnt = n;
        id = sz = vector<int>(n, 1);
        iota(id.begin(), id.end(), 0);
        for(auto &e: edges) {
            connect(e.first, e.second);
        }
        return cnt;
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
};
