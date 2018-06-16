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
        int left = height(root.left), right = height(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1)
            return false;
        return true;
    }
    
    private int height(TreeNode root) {
        if(root == null) return 0;
        int left = height(root.left), right = height(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}
