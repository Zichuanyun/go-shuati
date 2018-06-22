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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(root, result, String.valueOf(root.val));
        return result;
        
    }
    private void helper(TreeNode root, List<String> result, String cur) {
        if (root.left == null && root.right == null) {
            result.add(cur);
        }
        if (root.left != null) {
            helper(root.left, result, cur + "->" + String.valueOf(root.left.val));   
        }
        if (root.right != null) {
            helper(root.right, result, cur + "->" + String.valueOf(root.right.val));
        }
    }
}
