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
    int max_len = 0;
    int longestConsecutive(TreeNode* root) {
        if(!root) return 0;
        dfs(root);
        return max_len;
    }
    int dfs(TreeNode *node) {
        int left = 0, right = 0;
        if(node->left) {
            int len = dfs(node->left);
            if(node->left->val == node->val + 1)
                left = len;
        }
        if(node->right) {
            int len = dfs(node->right);
            if(node->right->val == node->val + 1)
                right = len;
        }
        int len = max(left, right) + 1;
        max_len = max(max_len, len);
        return len;
    }
};
