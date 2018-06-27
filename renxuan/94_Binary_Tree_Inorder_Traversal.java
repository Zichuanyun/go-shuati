/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while(curr != null) {
            s.push(curr);
            curr = curr.left;
        }
        while(!s.empty()) {
            curr = s.pop();
            res.add(curr.val);
            if(curr.right != null) {
                curr = curr.right;
                while(curr != null) {
                    s.push(curr);
                    curr = curr.left;
                }
            }
        }
        return res;
    }
}
