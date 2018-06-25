/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int findClosestLeaf(TreeNode* root, int k) {
        unordered_map<int, vector<int>> adj;
        unordered_set<int> vis, isLeaf;
        buildGraph(root, adj, isLeaf);
        if(isLeaf.count(k)) return k;

        vector<int> lvl, tlvl;
        lvl.push_back(k);
        vis.insert(k);
        while(!lvl.empty()) {
            tlvl.clear();
            for(auto u: lvl) {
                if(!adj.count(u)) continue;
                for(auto v: adj[u]) {
                    if(!vis.count(v)) {
                        if(isLeaf.count(v)) return v;
                        vis.insert(v);
                        tlvl.push_back(v);
                    }
                }
            }
            lvl.swap(tlvl);
        }
        return -1;
    }
    void buildGraph(TreeNode *root, unordered_map<int, vector<int>> &adj, unordered_set<int> &isLeaf) {
        if(!root->left && !root->right) isLeaf.insert(root->val);
        for(int i = 0; i < 2; i++) {
            auto p = (i == 0 ? root->left : root->right);
            if(p) {
                adj[root->val].push_back(p->val);
                adj[p->val].push_back(root->val);
                buildGraph(p, adj, isLeaf);
            }
        }
    }
};
