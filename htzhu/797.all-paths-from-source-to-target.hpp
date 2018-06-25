class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        vector<int> path;
        vector<vector<int>> ans;
        dfs(0, path, graph.size() - 1, ans, graph);
        return ans;
    }
    void dfs(int u, vector<int> &path, int dst, vector<vector<int>> &ans, vector<vector<int>> &adj) {
        path.push_back(u);
        if(u == dst) {
            ans.push_back(path);
        } else {
            for(auto v: adj[u]) {
                dfs(v, path, dst, ans, adj);
            }
        }
        path.pop_back();
    }
};
