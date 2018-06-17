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
    int maxPathSum(TreeNode* root) {
        int ans = INT_MIN;
        dfs(root, ans);
        return ans;
    }
    int dfs(TreeNode *node, int &ans) {
        if(!node) return 0;
        int left = dfs(node->left, ans), right = dfs(node->right, ans);
        int maxPath = max(0, max(left, right)) + node->val;
        ans = max(ans, max(left + right + node->val, maxPath));
        return maxPath;
    }
};
