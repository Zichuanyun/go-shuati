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
    public int findClosestLeaf(TreeNode root, int k) {
        if(root==null) return -1;
        Map<TreeNode, TreeNode> backMap = new HashMap<>();
        TreeNode resNode = DFS(root, k, backMap);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(resNode);
        visited.add(resNode);
        int dis = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left==null&&node.right==null){
                return node.val;
            }
            enqueueNode(node.left, queue, visited);
            enqueueNode(node.right, queue, visited);
            enqueueNode(backMap.get(node), queue, visited);
            dis = dis+1;
        }
        return -1;
    }
    
    private TreeNode DFS(TreeNode node, int value, Map<TreeNode, TreeNode> backMap){
        if(node==null) return null;
        if(node.val==value) return node;
        TreeNode resL=null, resR=null;
        if(node.left!=null){
            backMap.put(node.left, node);
            resL = DFS(node.left, value, backMap);
        }
        if(node.right!=null){
            backMap.put(node.right, node);
            resR = DFS(node.right, value, backMap);
        }
        if(resL!=null) return resL;
        if(resR!=null) return resR;
        return null;
    }
    
    private void enqueueNode(TreeNode node, Queue<TreeNode> queue, Set<TreeNode> set){
        if(node!=null && !set.contains(node)){
            queue.offer(node);
            set.add(node);
        }
    }
}
