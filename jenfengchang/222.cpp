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
    int countNodes(TreeNode* root) {
        int left_height = -1;
        int right_height = -1;
        TreeNode* cur = root;
        while (cur!=NULL) {
            left_height++;
            cur = cur->left;
        }
        cur = root;
        while (cur!=NULL) {
            right_height++;
            cur = cur->right;
        } 
        if (left_height == right_height) {
            return pow(2, left_height + 1) - 1;
        }
        int l = 0;
        int r = pow(2, left_height) - 1;
        while(l<r) {
            int mid = (r - l) / 2 + l;
            if(found(root, mid, left_height)) {
                l = mid;
                if(mid + 1 <= pow(2, left_height) - 1 && !found(root, mid + 1, left_height)) {
                    break;
                }
            } else {
                r = mid - 1;
            }
        }
        return pow(2, left_height) + l;
    }
    bool found(TreeNode* root, int mid, int height) {
        TreeNode* cur = root;
        while (height > 0) {
            if (mid >= pow(2, height - 1)) {
                mid -= pow(2, height - 1);
                cur = cur->right;
            } else {
                cur = cur->left;
            }
            height--;
        }
        if (cur == NULL)
            return false;
        return cur != NULL;
    }
};
