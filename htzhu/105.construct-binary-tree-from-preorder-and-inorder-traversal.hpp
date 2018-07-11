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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return build(0, preorder.size() - 1, 0, inorder.size() - 1, preorder, inorder);
    }
    TreeNode* build(int pl, int pr, int il, int ir, vector<int>& pnums, vector<int> &inums) {
        if(pl > pr) return NULL;
        int rootVal = pnums[pl];
        auto root = new TreeNode(rootVal);
        int i = il;
        while(inums[i] != rootVal && i < ir) i++;
        int len = i - il;
        root->left = build(pl + 1, pl + len, il, i - 1, pnums, inums);
        root->right = build(pl + len + 1, pr, i + 1, ir, pnums, inums);
        return root;
    }
};
