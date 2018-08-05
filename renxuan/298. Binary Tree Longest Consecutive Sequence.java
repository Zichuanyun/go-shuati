/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    int maxLen = 0;
    
    public int longestConsecutive(TreeNode root) {
        helper(root, 0, 0);
        return maxLen;
    }
    
    private void helper(TreeNode node, int parent, int parentLen) {
        if(node == null) return;
        int localLen = 1;
        if(parentLen != 0 && parent + 1 == node.val) {
            localLen = parentLen + 1;
        }
        maxLen = Math.max(maxLen, localLen);
        helper(node.left, node.val, localLen);
        helper(node.right, node.val, localLen);
    }
}
