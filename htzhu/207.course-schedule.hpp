class Solution {
public:
    bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
        vector<vector<int>> adj(numCourses);
        for(auto &e: prerequisites) {
            adj[e.second].push_back(e.first);
        }
        vector<int> vis(numCourses);
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, adj, vis)) {
                return false;
            }
        }
        return true;
    }
    bool dfs(int u, vector<vector<int>> &adj, vector<int> &vis) {
        if(vis[u] == -1) return false;
        if(vis[u]) return true;
        vis[u] = -1;
        for(int v: adj[u]) {
            if(!dfs(v, adj, vis)) {
                return false;
            }
        }
        vis[u] = 1;
        return true;
    }
};
