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
    int res = 0;
public:
    int sumNumbers(TreeNode* root) {
        InOrderTraversal(root, 0);
        return res;
    }
    void InOrderTraversal(TreeNode* root, int sum) {
        if(root == NULL)
            return;
        sum = sum * 10 + root->val;
        if(root->left == NULL & root->right == NULL) {
            res += sum;
        }
        InOrderTraversal(root->left, sum);
        InOrderTraversal(root->right, sum);
    }
};
