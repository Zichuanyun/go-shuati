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
    vector<vector<int>> findLeaves(TreeNode* root) {
        vector<vector<int>> ans;
        height(root, ans);
        return ans;
    }
    int height(TreeNode *node, vector<vector<int>> &ans) {
        if(!node) return -1;
        int h = 1 + max(height(node->left, ans), height(node->right, ans));
        if(h == ans.size()) ans.emplace_back();
        ans[h].push_back(node->val);
        return h;
    }
};
