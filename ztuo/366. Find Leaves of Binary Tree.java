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
    public List<List<Integer>> findLeaves(TreeNode root) {
         List<List<Integer>> list = new ArrayList<>();
         height(list, root);
         return list;
    }
    public int height(List<List<Integer>> list, TreeNode root) {
        if(root == null) return -1;
        int left = height(list, root.left);
        int right = height(list, root.right);
        int h = Math.max(left, right) + 1;
        if(list.size()  == h) {
            list.add(new ArrayList<Integer>());
        }
        list.get(h).add(root.val);
        return h;
    }
}