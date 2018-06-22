class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<pair<int, int>>& edges) {
        if(n == 0) return {};
        if(edges.empty()) return {0};
        vector<vector<int>> adj(n);
        for(auto &e: edges) {
            adj[e.first].push_back(e.second);
            adj[e.second].push_back(e.first);
        }
        int src = 0, maxLen = 0;
        dfs(0, 0, src, 0, maxLen, adj);
        vector<int> path, res;
        dfs2(src, path, res, adj);
        int m = res.size();
        if(m % 2) {
            return {res[m/2]};
        } else {
            return {res[m/2 - 1], res[m/2]};
        }
    }
    void dfs(int p, int prev, int &dst, int len, int &maxLen, vector<vector<int>> &adj) {
        if(len > maxLen) {
            dst = p;
            maxLen = len;
        }
        for(int q: adj[p]) {
            if(q != prev) {
                dfs(q, p, dst, len + 1, maxLen, adj);
            }
        }
    }
    void dfs2(int p, vector<int> &path, vector<int> &res, vector<vector<int>> &adj) {
        int prev = path.empty() ? p : path.back();
        path.push_back(p);
        if(path.size() > res.size()) {
            res = path;
        }
        for(int q: adj[p]) {
            if(q != prev) {
                dfs2(q, path, res, adj);
            }
        }
        path.pop_back();
    }
};
