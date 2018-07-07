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
    public boolean isBalanced(TreeNode root) {    
        if(root == null) return true;
        if(Math.abs(getDepth(root.right) - getDepth(root.left)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int getDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}