/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if(!node) return NULL;
        unordered_map<int, UndirectedGraphNode*> mp;
        queue<UndirectedGraphNode*> q;
        q.push(node);
        auto newNode = new UndirectedGraphNode(node->label);
        mp[node->label] = newNode;
        while(!q.empty()) {
            auto u = q.front(); q.pop();
            auto newU = mp[u->label];
            for(auto v: u->neighbors) {
                if(mp.count(v->label)) {
                    newU->neighbors.push_back(mp[v->label]);
                } else {
                    auto newV = new UndirectedGraphNode(v->label);
                    mp[v->label] = newV;
                    newU->neighbors.push_back(newV);
                    q.push(v);
                }
            }
        }
        return newNode;
    }
};
