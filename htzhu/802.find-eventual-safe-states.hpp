class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<vector<int>> revGraph(n);
        for(int i = 0; i < n; i++) {
            for(int j: graph[i]) {
                revGraph[j].push_back(i);
            }
        }
        stack<int> topo;
        vector<bool> vis(n);
        for(int i = 0; i < n; i++) {
            if(!vis[i]) topoSort(i, vis, topo, revGraph);
        }
        fill(vis.begin(), vis.end(), false);
        vector<bool> res(n, true);
        while(!topo.empty()) {
            int u = topo.top(); topo.pop();
            if(vis[u]) continue;
            bool ok = true;
            // If has an unvisited or invalid out edge
            for(auto v: graph[u]) {
                if(!vis[v] || !res[v]) {
                    ok = false;
                    break;
                }
            }
            if(ok) {
                vis[u] = true;
            } else {
                scc(u, vis, res, graph);
            }
        }
        vector<int> ans;
        for(int i = 0; i < n; i++)
            if(res[i]) ans.push_back(i);
        return ans;
    }
    void topoSort(int u, vector<bool> &vis, stack<int> &path, vector<vector<int>> &adj) {
        vis[u] = true;
        for(auto v: adj[u]) {
            if(!vis[v]) topoSort(v, vis, path, adj);
        }
        path.push(u);
    }
    void scc(int u, vector<bool> &vis, vector<bool> &res, vector<vector<int>> &adj) {
        vis[u] = true;
        res[u] = false;
        for(auto v: adj[u]) {
            if(!vis[v]) scc(v, vis, res, adj);
        }
    }
};
