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
    int globalMax = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return globalMax;
    }
    
    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        int localMax = root.val + Math.max(0, left) + Math.max(0, right);
        globalMax = Math.max(globalMax, localMax);
        return root.val + Math.max(0, Math.max(left, right));
    }
}
