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
    
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }   
    
    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left), right = helper(root.right);
        res = Math.max(res, left + right);
        return 1 + Math.max(left, right);
    }
}
