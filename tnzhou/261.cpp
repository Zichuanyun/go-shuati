class Solution {
public:
    bool validTree(int n, vector<pair<int, int>>& edges) {
        vector<int> v[n];
        for (auto p : edges) {
            v[p.first].push_back(p.second);
            v[p.second].push_back(p.first);
        }
        bool visited[n];
        memset(visited, 0, sizeof visited);
        bool multireach = dfs(v, 0, visited, -1);
        if (multireach)
            return false;
        for (bool x : visited) {
            if (!x)
                return false;
        }
        return true;
    }
    
    bool dfs(vector<int>v[], int cur, bool visited[], int fa) {
        visited[cur] = true;
        bool res = false;
        for (int x : v[cur]) {
            if (x != fa) {
                if (visited[x])
                    return true;
                res |= dfs(v, x, visited, cur);
            }
        }
        return res;
    }
};
