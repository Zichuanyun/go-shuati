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
    public int findClosestLeaf(TreeNode root, int k) {
        if(root == null || root.left == null && root.right == null && k != root.val) {
            return -1;
        }
        
        Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Set<Integer> visited = new HashSet<Integer>();
        TreeNode target = findTarget(root, k, map);
        
        queue.offer(target);
        visited.add(target.val);
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if(node.left == null && node.right == null) {
                return node.val;
            }
            
            if(node.left !=null && !visited.contains(node.left.val)) {
                queue.offer(node.left);
                visited.add(node.left.val);
            }
            
            if(node.right != null && !visited.contains(node.right.val)) {
                queue.offer(node.right);
                visited.add(node.right.val);
            }
            
            if(map.containsKey(node) && !visited.contains(map.get(node).val)) {
                queue.offer(map.get(node));
                visited.add(map.get(node).val);
                
            }
        }
        
        return -1;
        
    }
    
    private TreeNode findTarget(TreeNode root, int target, Map<TreeNode, TreeNode> map) {
        if(root.val == target) {
            return root;
        }
        
        if(root.left != null) {
            map.put(root.left, root);
            TreeNode left = findTarget(root.left, target, map);
            if(left != null) {
                return left;
            }
        }
        
        if(root.right != null) {
            map.put(root.right, root);
            TreeNode right = findTarget(root.right, target, map);
            if(right != null) {
                return right;
            }
        }
        
        return null;
    }
}
