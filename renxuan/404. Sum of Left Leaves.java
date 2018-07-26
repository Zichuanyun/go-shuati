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
    int res = 0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        return res;
    }
    
    private void helper(TreeNode node, boolean isLeft) {
        if(node == null) return;
        if(node.left == null && node.right == null && isLeft)
            res += node.val;
        helper(node.left, true);
        helper(node.right, false);
    }
}
