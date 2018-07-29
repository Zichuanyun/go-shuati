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
    TreeNode *prev = NULL;
public:
    TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
        if(!root) return prev;
        if(root->val <= p->val) {
            return inorderSuccessor(root->right, p);
        } else {
            prev = root;
            return inorderSuccessor(root->left, p);
        }
    }
};
