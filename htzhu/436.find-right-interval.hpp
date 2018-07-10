/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
struct Node {
    int l, r, id;
    Node(int l, int r, int id):l(l), r(r), id(id) {}
    bool operator < (const Node &rhs) const {
        return l < rhs.l;
    }
};

class Solution {
public:
    vector<int> findRightInterval(vector<Interval>& intervals) {
        vector<Node> nodes;
        int n = intervals.size();
        for(int i = 0; i < n; i++) {
            auto &itv = intervals[i];
            nodes.emplace_back(itv.start, itv.end, i);
        }
        sort(nodes.begin(), nodes.end());
        vector<int> ans(n);
        for(auto &x: nodes) {
            auto it = lower_bound(nodes.begin(), nodes.end(), x.r,
                                  [](const Node &node, int rhs) { return node.l < rhs; });
            ans[x.id] = (it == nodes.end() ? -1 : it->id);
        }
        return ans;
    }
};
