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
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(temp != null) {
            res.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            temp = temp.left;
            if (temp == null && !stack.isEmpty()) {
                temp = stack.pop();
            }
	    }
        return res;
    }
}