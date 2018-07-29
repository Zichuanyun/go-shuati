struct Node {
    int id;
    int cnt;
    Node(int id, int cnt): id(id), cnt(cnt) {}
    bool operator < (const Node &node) const {
        return cnt < node.cnt;
    }
};

class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int cnt[26] = {0};
        for(char c: tasks) cnt[c - 'A']++;
        priority_queue<Node> pq;
        for(int i = 0; i < 26; i++) {
            if(cnt[i] > 0) pq.emplace(i, cnt[i]);
        }
        int times = 0;
        vector<Node> nextNodes;
        while(!pq.empty()) {
            nextNodes.clear();
            for(int i = 0; i <= n; i++) {
                if(!pq.empty()) {
                    auto node = pq.top(); pq.pop();
                    if(--node.cnt > 0) {
                        nextNodes.emplace_back(node.id, node.cnt);
                    }
                } else if(nextNodes.empty()){
                    break;
                }
                times++;
            }
            for(auto &node: nextNodes) {
                pq.push(node);
            }
        }
        return times;
    }
};
