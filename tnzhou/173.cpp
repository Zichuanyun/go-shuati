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
public:
    stack<TreeNode *> st;
    
    BSTIterator(TreeNode *root) {
        TreeNode * curr = root;
        while (curr != NULL) {
            st.push(curr);
            curr = curr->left;
        }
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !st.empty();
    }

    /** @return the next smallest number */
    int next() {
        TreeNode * res = st.top();
        st.pop();
        if (res->right != NULL) {
            TreeNode * curr = res->right;
            while (curr != NULL) {
                st.push(curr);
                curr = curr->left;
            }
        }
        return res->val;
    }
};

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = BSTIterator(root);
 * while (i.hasNext()) cout << i.next();
 */
