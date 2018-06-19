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
    int sumres;
    public int maxPathSum(TreeNode root) {
        sumres = Integer.MIN_VALUE;
        ms(root);
        return sumres;
    }
    
    private int ms(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0, ms(root.left));
        int right = Math.max(0, ms(root.right));
        
        sumres = Math.max(sumres, root.val + left + right);
        
        return root.val + Math.max(left, right);
        
    }
}