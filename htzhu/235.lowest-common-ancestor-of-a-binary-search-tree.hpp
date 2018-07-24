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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(p->val > q->val) swap(p, q);
        return dfs(root, p, q);
    }
    TreeNode *dfs(TreeNode *node, TreeNode *p, TreeNode *q) {
        if(node->val == p->val || node->val == q->val) return node;
        if(node->val < p->val) {
            return dfs(node->right, p, q);
        } else if(node->val < q->val) {
            return node;
        } else {
            return dfs(node->left, p, q);
        }
    }
};
