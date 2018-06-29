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
    bool isSymmetric(TreeNode* root) {
        if(!root) return true;
        return helper(root->left, root->right);
    }
    bool helper(TreeNode *p, TreeNode *q) {
        if(!p) return !q;
        if(!q) return !p;
        return p->val == q->val &&
            helper(p->left, q->right) &&
            helper(p->right, q->left);
    }
};
