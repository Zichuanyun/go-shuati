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
        List<String> res = new ArrayList<>();
        if(root != null) dfs(root, res, "");
        return res;
    }
    
    private void dfs(TreeNode root, List<String> res, String fromParent) {
        if(root.left == null && root.right == null) 
            res.add(fromParent + root.val);
        if(root.left != null)
            dfs(root.left, res, fromParent + root.val + "->");
        if(root.right != null)
            dfs(root.right, res, fromParent + root.val + "->");
    }
}