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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        long prev = Long.MIN_VALUE;
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while(curr != null) {
            s.push(curr);
            curr = curr.left;
        }
        while(!s.empty()) {
            curr = s.pop();
            if(prev >= curr.val) return false;
            prev = curr.val;
            if(curr.right != null) {
                curr = curr.right;
                while(curr != null) {
                    s.push(curr);
                    curr = curr.left;
                }
            }
        }
        return true;
    }
}
