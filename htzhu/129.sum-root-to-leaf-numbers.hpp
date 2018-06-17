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
    int sumNumbers(TreeNode* root) {
        if(!root) return 0;
        int ans = 0;
        dfs(root, 0, ans);
        return ans;
    }
    void dfs(TreeNode *node, int num, int &sum) {
        int cur = num * 10 + node->val;
        if(!node->left && !node->right) {
            sum += cur;
            return;
        }
        if(node->left) {
            dfs(node->left, cur, sum);
        }
        if(node->right) {
            dfs(node->right, cur, sum);
        }
    }
};
