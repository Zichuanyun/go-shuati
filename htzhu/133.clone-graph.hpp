/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
    unordered_map<int, UndirectedGraphNode*> mp;
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if(!node) return NULL;
        int label = node->label;
        if(mp.count(label)) return mp[label];
        auto newNode = new UndirectedGraphNode(label);
        mp[label] = newNode;
        for(auto u: node->neighbors) {
            newNode->neighbors.push_back(cloneGraph(u));
        }
        return newNode;
    }
};
