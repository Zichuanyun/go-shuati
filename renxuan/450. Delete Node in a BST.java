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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode curr = root, prev = null;
        while(curr != null && curr.val != key) {
            prev = curr;
            if(key < curr.val) curr = curr.left;
            else curr = curr.right;
        }
        if(prev == null) return delete(curr);
        if(prev.left == curr) prev.left = delete(curr);
        else prev.right = delete(curr);
        return root;
    }
    
    private TreeNode delete(TreeNode root) {
        if(root == null) return null;
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;
        TreeNode curr = root.right, prev = curr;
        while(curr.left != null) {
            prev = curr;
            curr = curr.left;
        }
        curr.left = root.left;
        if(prev.left == curr) {
            prev.left = curr.right;
            curr.right = root.right;
        }        
        return curr;
    }
}
