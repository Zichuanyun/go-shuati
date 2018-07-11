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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        return build(0, postorder.size() - 1, 0, inorder.size() - 1, postorder, inorder);
    }
    TreeNode *build(int pl, int pr, int il, int ir, vector<int> &pnums, vector<int> &inums) {
        if(pl > pr) return NULL;
        int rootVal = pnums[pr];
        auto root = new TreeNode(rootVal);
        int i = il;
        while(i < ir && inums[i] != rootVal) i++;
        int len = ir - i;
        root->right = build(pr - len, pr - 1, i + 1, ir, pnums, inums);
        root->left = build(pl, pr - len - 1, il, i - 1, pnums, inums);
        return root;
    }
};
