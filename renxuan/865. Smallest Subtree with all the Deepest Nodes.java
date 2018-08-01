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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        int h = height(map, root);
        while(root.left != null || root.right != null) {
            if(root.left == null) root = root.right;
            else if(root.right == null) root = root.left;
            else {
                int left = map.get(root.left), right = map.get(root.right);
                if(left == right) return root;
                else if(left > right) root = root.left;
                else root = root.right;
            }
        }
        return root;
    }
    
    private int height(Map<TreeNode, Integer> map, TreeNode root) {
        if(root == null) return 0;
        int left = height(map, root.left), right = height(map, root.right);
        int height = 1 + Math.max(left, right);
        map.put(root, height);
        return height;
    }
}
