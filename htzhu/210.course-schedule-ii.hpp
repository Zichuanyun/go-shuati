class Solution {
public:
    vector<int> findOrder(int numCourses, vector<pair<int, int>>& prerequisites) {
        vector<vector<int>> adj(numCourses);
        for(auto &pr: prerequisites) {
            adj[pr.second].push_back(pr.first);
        }
        vector<int> path, vis(numCourses);
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, adj, path, vis)) return {};
        }
        reverse(path.begin(), path.end());
        return path;
    }
    bool dfs(int u, vector<vector<int>> &adj, vector<int> &path, vector<int> &vis) {
        if(vis[u] == -1) return false;
        if(vis[u] == 1) return true;
        vis[u] = -1;
        for(auto v: adj[u]) {
            if(!dfs(v, adj, path, vis)) return false;
        }
        vis[u] = 1;
        path.push_back(u);
        return true;
    }
};
