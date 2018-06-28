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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        s.push(root);
        while(!s.empty()) {
            TreeNode temp = stack.pop();
            res.add(0, temp.val);
            if(temp.left != null) stack.push(temp.left);
            if(temp.right != null) stack.push(temp.right);
        }
        return res;
    }
}