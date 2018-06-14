/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
    unordered_map<UndirectedGraphNode*, UndirectedGraphNode*> map;
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if(node == NULL) return NULL;
        UndirectedGraphNode *begin = new UndirectedGraphNode(node->label);
        DFS(begin, node);
        return begin;
    }
    void DFS(UndirectedGraphNode *begin, UndirectedGraphNode *node) {
        if (map[node] != nullptr) {
            return;
        }
        map[node] = begin;
        for (auto &neighbor : node->neighbors) {
            if (map[neighbor] == nullptr) {
                UndirectedGraphNode *new_node = new UndirectedGraphNode(neighbor->label);
                begin->neighbors.push_back(new_node);
                DFS(new_node, neighbor);
            } else {
                begin->neighbors.push_back(map[neighbor]);
            } 
        }
    }
};
