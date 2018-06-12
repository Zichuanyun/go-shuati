class Solution {
    vector<int> id, sz;
    int cnt;
public:
    bool validTree(int n, vector<pair<int, int>>& edges) {
        sz = id = vector<int>(n);
        fill(sz.begin(), sz.end(), 1);
        iota(id.begin(), id.end(), 0);
        cnt = n;
        for(auto &edge: edges) {
            if(!connect(edge.first, edge.second)) {
                return false;
            }
        }
        return cnt == 1;
    }
    int find(int x) {
        return x == id[x] ? x : id[x] = find(id[x]);
    }
    bool connect(int x, int y) {
        int p = find(x);
        int q = find(y);
        if(p == q) return false;
        if(sz[p] < sz[q]) swap(p, q);
        id[q] = p;
        sz[p] += sz[q];
        cnt--;
        return true;
    }
};
