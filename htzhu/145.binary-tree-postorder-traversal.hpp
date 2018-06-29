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
    vector<int> postorderTraversal(TreeNode* root) {
        list<int> ans;
        stack<TreeNode*> stk;
        auto p = root;
        while(!stk.empty() || p) {
            if(p) {
                stk.push(p);
                ans.push_front(p->val);
                p = p->right;
            } else {
                p = stk.top()->left;
                stk.pop();
            }
        }
        return vector<int>(ans.begin(), ans.end());
    }
};
