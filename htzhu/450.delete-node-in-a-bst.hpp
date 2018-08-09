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
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(!root) return NULL;
        if(root->val == key) {
            if(!root->left) {
                auto tmp = root->right;
                delete root;
                return tmp;
            } else if(!root->right) {
                auto tmp = root->left;
                delete root;
                return tmp;
            } else {
                auto x = root->right;
                while(x->left) x = x->left;
                root->val = x->val;
                root->right = deleteNode(root->right, x->val);
            }
        } else if(key < root->val) {
            root->left = deleteNode(root->left, key);
        } else {
            root->right = deleteNode(root->right, key);
        }
        return root;
    }
};
