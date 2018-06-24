class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<int> color(n, -1);
        for(int i = 0; i < n; i++) {
            if(color[i] < 0 && !dfs(i, 0, color, graph)) return false;
        }
        return true;
    }
    bool dfs(int u, int c, vector<int> &color, vector<vector<int>> &graph) {
        if(color[u] >= 0) {
            return color[u] == c;
        }
        color[u] = c;
        for(auto v: graph[u]) {
            if(!dfs(v, c ^ 1, color, graph)) return false;
        }
        return true;
    }
};
