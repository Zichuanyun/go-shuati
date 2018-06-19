/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lefth = 0, righth = 0;
        TreeNode cur = root;
        while (cur != null) {
            lefth += 1;
            cur = cur.left;
        }
        cur = root;
        while (cur != null) {
            righth += 1;
            cur = cur.right;
        }
        if (lefth == righth) {
            return (int) Math.pow(2, lefth) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
