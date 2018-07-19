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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        if(root != null) queue.add(root);
        while(queue.size()!=0) {
            List<Integer> tmpList = new ArrayList<>();
            int size = queue.size();
            while(size>0) {
                TreeNode tmpNode = queue.poll();
                tmpList.add(tmpNode.val);
                if(tmpNode.left!=null) queue.offer(tmpNode.left);
                if(tmpNode.right!=null) queue.offer(tmpNode.right);
                --size;
            }
            res.add(tmpList);            
        }
        return res;
    }
}
