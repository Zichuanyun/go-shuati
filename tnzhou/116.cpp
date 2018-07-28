/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
public:
    void connect(TreeLinkNode *root) {
        if (root == NULL)
            return;
        TreeLinkNode * cur = root -> next;
        while (cur != NULL) {
            if (cur->left != NULL) {
                cur = cur->left;
                break;
            }
            if (cur->right != NULL) {
                cur = cur->right;
                break;
            }
            cur = cur->next;
        }
        if (root->right != NULL)
            root->right->next = cur;
        if (root->left != NULL) {
            if (root->right != NULL)
                root->left->next = root->right;
            else
                root->left->next = cur;
        }
        connect(root->right);
        connect(root->left);
    }
};
