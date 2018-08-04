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
    int kthSmallest(TreeNode* root, int k) {
        int ans;
        inorder(root, k, ans);
        return ans;
    }
    void inorder(TreeNode *node, int &k, int &ans) {
        if(!node || k < 0) return;
        inorder(node->left, k, ans);
        if(--k == 0) {
            ans = node->val;
            return;
        }
        inorder(node->right, k, ans);
    }
};
