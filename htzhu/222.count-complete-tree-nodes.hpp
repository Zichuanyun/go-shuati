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
    int countNodes(TreeNode* root) {
        return dfs(root, height(root));
    }
    int dfs(TreeNode *node, int h) {
        if(!node) return 0;
        return height(node->right) == h - 1
            ? (1 << h) + dfs(node->right, h - 1)
            : (1 << (h - 1)) + dfs(node->left, h - 1);
    }
    int height(TreeNode *node) {
        return node ? 1 + height(node->left) : -1;
    }
};
