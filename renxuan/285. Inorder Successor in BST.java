/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        if(p.right != null) {
            TreeNode next = p.right;
            while(next.left != null) next = next.left;
            return next;
        }
        TreeNode node = root, lastGoLeft = null;
        while(node != p) {
            if(node.val < p.val) {
                node = node.right;
            }
            else {
                lastGoLeft = node;
                node = node.left;
            }
        }
        return lastGoLeft;
    }
}
