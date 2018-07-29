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
    int sumOfLeftLeaves(TreeNode* root) {
        if(!root) return 0;
        int ans = 0;
        dfs(root, false, ans);
        return ans;
    }
    void dfs(TreeNode *node, bool isLeft, int &sum) {
        if(!node->left && !node->right && isLeft) {
            sum += node->val;
            return;
        }
        if(node->left) dfs(node->left, true, sum);
        if(node->right) dfs(node->right, false, sum);
    }
};
