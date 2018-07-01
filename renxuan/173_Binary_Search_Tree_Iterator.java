/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        TreeNode curr = root;
        while(root != null) {
            s.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = s.pop();
        TreeNode right = top.right;
        while(right != null) {
            s.push(right);
            right = right.left;
        }
        return top.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
 