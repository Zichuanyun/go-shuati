class Solution {
    vector<string> ans;
    unordered_map<string, multiset<string>> adj;
public:
    vector<string> findItinerary(vector<pair<string, string>> tickets) {
        for(auto &pr: tickets) {
            adj[pr.first].insert(pr.second);
        }
        dfs("JFK");
        return vector<string>(ans.rbegin(), ans.rend());
    }
    void dfs(string u) {
        while(adj.count(u) && !adj[u].empty()) {
            auto it = adj[u].begin();
            string v = *it;
            adj[u].erase(it);
            dfs(v);
        }
        ans.push_back(u);
    }
};
