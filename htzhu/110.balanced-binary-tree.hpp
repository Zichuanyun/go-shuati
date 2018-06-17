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
    bool isBalanced(TreeNode* root) {
        bool ans = true;
        dfs(root, ans);
        return ans;
    }
    int dfs(TreeNode *node, bool &ans) {
        if(!node) return 0;
        int left = dfs(node->left, ans), right = dfs(node->right, ans);
        if(!ans) return -1;
        if(abs(left - right) > 1) ans = false;
        return 1 + max(left, right);
    }
};
