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
    public int kthSmallest(TreeNode root, int k) {
        Map<TreeNode, Integer> childNum = new HashMap<>();
        countChildren(childNum, root);
        while(k >= 1) {
            int left = (root.left == null) ? 0 : childNum.get(root.left);
            if(left + 1 == k) {
                return root.val;
            }
            if(left >= k) {
                root = root.left;
            }
            else {
                root = root.right;
                k -= left + 1;
            }
        }
        return root.val;
    }
    
    private int countChildren(Map<TreeNode, Integer> childNum, TreeNode node) {
        if(node == null) return 0;
        int left = countChildren(childNum, node.left), right = countChildren(childNum, node.right);
        int total = left + right + 1;
        childNum.put(node, total);
        return total;
    }
}
