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
    TreeNode *node;
public:
    TreeNode* upsideDownBinaryTree(TreeNode* root) {
        if(!root) return NULL;
        dfs(root);
        return node;
    }
    void dfs(TreeNode *root) {
        node = root;
        if(root->left) {
            dfs(root->left);
            root->left->left = root->right;
            root->left->right = root;
            root->left = root->right = NULL;
        }
    }
};
