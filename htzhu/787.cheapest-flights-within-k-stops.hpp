class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int K) {
        vector<int> dis(n, -1);
        vector<vector<pair<int, int>>> adj(n);
        for(auto &flight: flights) {
            adj[flight[0]].push_back({flight[1], flight[2]});
        }
        queue<int> q;
        q.push(src);
        dis[src] = 0;
        K++;
        while(K-- && !q.empty()) {
            int sz = q.size();
            auto tdis = dis;
            while(sz--) {
                int u = q.front(); q.pop();
                for(auto &pr: adj[u]) {
                    int v = pr.first, d = pr.second;
                    if(tdis[v] == -1 || dis[u] + d < tdis[v]) {
                        tdis[v] = dis[u] + d;
                        q.push(v);
                    }
                }
            }
            dis = tdis;
        }
        return dis[dst];
    }
};
