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
    public int countNodes(TreeNode root) {
        int h = height(root), res = 0;
        while(root != null) {
            if(height(root.right) == h - 1) {
                res += 1 << h;
                root = root.right;
            }
            else {
                res += 1 << (h - 1);
                root = root.left;
            }
            --h;
        }
        return res;
    }
    
    private int height(TreeNode root) {
        if(root == null) return -1;
        return 1 + height(root.left);
    }
}