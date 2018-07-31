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
    TreeNode* subtreeWithAllDeepest(TreeNode* root) {
        if(!root) return NULL;
        vector<TreeNode*> deepestNodes;
        int maxDepth = 0;
        getDeepestNodes(root, 0, maxDepth, deepestNodes);
        auto node = deepestNodes[0];
        for(int i = 1; i < deepestNodes.size(); i++) {
            node = lca(root, node, deepestNodes[i]);
        }
        return node;
    }
    void getDeepestNodes(TreeNode *node, int depth, int &maxDepth, vector<TreeNode*> &res) {
        if(!node) return;
        if(depth > maxDepth) {
            maxDepth = depth;
            res.clear();
        }
        if(depth >= maxDepth) {
            res.push_back(node);
        }
        getDeepestNodes(node->left, depth + 1, maxDepth, res);
        getDeepestNodes(node->right, depth + 1, maxDepth, res);
    }
    TreeNode *lca(TreeNode *root, TreeNode *p, TreeNode *q) {
        if(!root) return NULL;
        if(root->val == p->val || root->val == q->val) return root;
        auto left = lca(root->left, p, q), right = lca(root->right, p, q);
        if(left && right) {
            return root;
        } else if(left) {
            return left;
        } else {
            return right;
        }
    }
};
