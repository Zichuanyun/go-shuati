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
    vector<int> preorderTraversal(TreeNode* root) {
        stack<TreeNode*> stk;
        vector<int> ans;
        if(root) stk.push(root);
        while(!stk.empty()) {
            auto x = stk.top(); stk.pop();
            ans.push_back(x->val);
            if(x->right) stk.push(x->right);
            if(x->left) stk.push(x->left);
        }
        return ans;
    }
};
