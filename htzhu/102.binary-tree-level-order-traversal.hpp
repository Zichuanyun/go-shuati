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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        dfs(root, 0, ans);
        return ans;
    }
    void dfs(TreeNode *node, int depth, vector<vector<int>> &ans) {
        if(!node) return;
        if(depth >= ans.size()) {
            ans.emplace_back();
        }
        ans[depth].push_back(node->val);
        depth++;
        dfs(node->left, depth, ans);
        dfs(node->right, depth, ans);
    }
};
