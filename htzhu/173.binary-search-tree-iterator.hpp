/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class BSTIterator {
    stack<TreeNode*> stk;
public:
    BSTIterator(TreeNode *root) {
        pushLeftDown(root);
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !stk.empty();
    }

    /** @return the next smallest number */
    int next() {
        auto node = stk.top(); stk.pop();
        pushLeftDown(node->right);
        return node->val;
    }
    void pushLeftDown(TreeNode *node) {
        while(node) {
            stk.push(node);
            node = node->left;
        }
    }
};

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = BSTIterator(root);
 * while (i.hasNext()) cout << i.next();
 */
