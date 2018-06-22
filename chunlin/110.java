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
    public boolean isBalanced(TreeNode root) {      // if root == null return false -> WA
        ResultType result = helper(root);
        return result.isBalanced;
    }
    private ResultType helper(TreeNode node) {
        if (node == null) {
            return new ResultType(true, 0);
        }
        ResultType left = helper(node.left);
        ResultType right = helper(node.right);
        
        if (left.isBalanced && right.isBalanced &&          // forgot
            Math.abs(left.depth - right.depth) <= 1) {
            return new ResultType(true, Math.max(left.depth, right.depth) + 1);     // forgot +1, WA
        }
        return new ResultType(false, 0);
    }
    class ResultType {
        public boolean isBalanced;
        public int depth;
        public ResultType(boolean isBalanced, int depth) {
            this.isBalanced = isBalanced;
            this.depth = depth;
        }
    }
}
