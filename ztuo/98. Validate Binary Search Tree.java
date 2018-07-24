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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root, long lowerBound, long upperBound) {
        if(root == null) return true;
        if(root.val <= lowerBound || root.val >= upperBound) return false;
        return isValid(root.left, lowerBound, root.val) && isValid(root.right, root.val, upperBound);
    }
}