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
    bool isValidBST(TreeNode* root) {
        if (root == NULL)
            return true;
        return validateBSTHelper(root->left, (long long) -2147483648 - 1, root->val) &&
            validateBSTHelper(root->right, root->val, (long long) 2147483647 + 1);
    }
    
    bool validateBSTHelper(TreeNode* node, long long down_limit, long long up_limit) {
        if (node == NULL)
            return true;
        if (node->val <= down_limit || node->val >= up_limit)
            return false;
        return validateBSTHelper(node->left, down_limit, node->val) &&
            validateBSTHelper(node->right, node->val, up_limit);
    }
};
