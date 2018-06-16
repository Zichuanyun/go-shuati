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
        if(root == NULL) 
            return true;
        int leftDepth = Depth(root->left);
        int rightDepth = Depth(root->right);
        if(leftDepth > rightDepth) {
            swap(leftDepth, rightDepth);
        }
        if(rightDepth > leftDepth + 1) {
            return false;
        }
        return isBalanced(root->left) && isBalanced(root->right);
    }
    int Depth(TreeNode* root) {
        if(root == NULL)
            return 0;
        return 1 + max(Depth(root->left), Depth(root->right));
    }
};
