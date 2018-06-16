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
    int maxDepth(TreeNode* root) {
        InOrderTraversal(root, 1);
        return res;
    }
    void InOrderTraversal(TreeNode* root, int lvl) {
        if(root == NULL) {
            return;
        }
        if(lvl > res) {
            res = lvl;
        }
        InOrderTraversal(root->left, lvl + 1);
        InOrderTraversal(root->right, lvl + 1);
    }
};
