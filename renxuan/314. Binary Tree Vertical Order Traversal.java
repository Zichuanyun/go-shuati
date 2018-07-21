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
    class Node {
        TreeNode treeNode;
        int column;
        Node(TreeNode treeNode, int column) {
            this.treeNode = treeNode;
            this.column = column;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));
        while(!q.isEmpty()) {
            Node node = q.poll();
            TreeNode treeNode = node.treeNode;
            int column = node.column;
            List<Integer> list = map.get(column);
            if(list == null) list = new ArrayList<>();
            list.add(treeNode.val);
            map.put(column, list);
            if(treeNode.left != null) q.offer(new Node(treeNode.left, column - 1));
            if(treeNode.right != null) q.offer(new Node(treeNode.right, column + 1));
        }
        for(int key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}
