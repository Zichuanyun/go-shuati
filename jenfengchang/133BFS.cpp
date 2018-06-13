/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
    unordered_map<UndirectedGraphNode *, bool> visited;
    unordered_map<int, UndirectedGraphNode *> map;
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if(node == NULL) return NULL;
        UndirectedGraphNode *begin = new UndirectedGraphNode(node->label);
        map[node->label] = begin;
        vector<UndirectedGraphNode*> cur;
        cur.push_back(node);
        while(!cur.empty()) {
            vector<UndirectedGraphNode*> next;
            for(auto &tmp : cur) {
                visited[tmp] = true;
                for(auto &N : tmp->neighbors) {
                    if(map[N->label] == NULL) {
                        UndirectedGraphNode *tmpnode = new UndirectedGraphNode(N->label);
                        map[N->label] = tmpnode;
                    }
                    map[tmp->label]->neighbors.push_back(map[N->label]);
                    if(!visited[N]) {
                        visited[N] = true;
                        next.push_back(N);
                    }
                }
            }
            cur = next;
        }
        return begin;
    }
};
