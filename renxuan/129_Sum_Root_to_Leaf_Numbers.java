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
    int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    
    private void dfs(TreeNode root, int preSum) {
        if(root == null) return;
        int curr = preSum * 10 + root.val;
        if(root.left == null && root.right == null)
            sum += curr;
        else {
            dfs(root.left, curr);
            dfs(root.right, curr);
        }
    }
}
