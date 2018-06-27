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
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.empty()) {
            TreeNode curr = s.pop();
            res.add(0, curr.val);
            if(curr.left != null) s.push(curr.left);
            if(curr.right != null) s.push(curr.right);
        }
        return res;
    }
}
