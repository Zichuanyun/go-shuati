/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    Map<Integer, List<TreeNode>> heightToNodes;
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        heightToNodes = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int h = height(root);
        for(int i = 1; i <= h; ++i) {
            List<Integer> tmp = new ArrayList<>();
            List<TreeNode> nodes = heightToNodes.get(i);
            for(TreeNode node : nodes) {
                tmp.add(node.val);
            }
            res.add(tmp);
        }
        return res;
    }
    
    private int height(TreeNode root) {
        if(root == null) return 0;
        int left = height(root.left), right = height(root.right);
        int height = 1 + Math.max(left, right);
        List<TreeNode> nodes = heightToNodes.getOrDefault(height, new ArrayList<>());
        nodes.add(root);
        heightToNodes.put(height, nodes);
        return height;
    }
}
