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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.empty()) {
            TreeNode curr = s.pop();
            res.add(curr.val);
            if(curr.right != null) s.push(curr.right);
            if(curr.left != null) s.push(curr.left);
        }
        return res;
    }
}
