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
    vector<int> inorderTraversal(TreeNode* root) {
        stack<TreeNode*> stk;
        vector<int> ans;
        pushAllLeft(root, stk);
        while(!stk.empty()) {
            auto x = stk.top(); stk.pop();
            ans.push_back(x->val);
            pushAllLeft(x->right, stk);
        }
        return ans;
    }
    void pushAllLeft(TreeNode *node, stack<TreeNode*> &stk) {
        while(node) {
            stk.push(node);
            node = node->left;
        }
    }
};
