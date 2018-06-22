struct Node {
    int id, w, k;
    Node(int id, int w, int k): id(id), w(w), k(k) {}
    bool operator < (const Node &rhs) const {
        return w > rhs.w;
    }
};
class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int K) {
        vector<vector<pair<int, int>>> adj(n);
        for(auto &flight: flights) {
            adj[flight[0]].push_back({flight[1], flight[2]});
        }
        priority_queue<Node> pq;
        pq.push(Node(src, 0, K));
        while(!pq.empty()) {
            auto node = pq.top(); pq.pop();
            if(node.id == dst) return node.w;
            if(node.k < 0) continue;
            for(auto &pr: adj[node.id]) {
                pq.push(Node(pr.first, node.w + pr.second, node.k - 1));
            }
        }
        return -1;
    }
};
