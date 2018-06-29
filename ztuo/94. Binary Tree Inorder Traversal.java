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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        TreeNode temp = root;
        while(!stack.isEmpty() || temp != null) {
            while(temp != null) {
                stack.add(temp);
                temp = temp.left;                
            }
            temp = stack.pop();
            res.add(temp.val);
            temp = temp.right;   
        }
        return res;        
    }   
}