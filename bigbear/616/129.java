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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        add(root, 0);
        return sum;
    }
    
    private void add(TreeNode root, int subsum){
        if(root == null){
            return;
        }
        subsum = subsum * 10 + root.val;
        
        if(root.left ==null && root.right == null) {
            sum += subsum;
        }
        
        add(root.left, subsum);
        add(root.right, subsum);
    }
}