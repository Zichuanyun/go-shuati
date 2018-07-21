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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        queue.add(root);
        col.add(0);
        int min = 0;
        int max = 0;
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            int currcol = col.poll();
            if (!map.containsKey(currcol)) {
                map.put(currcol, new ArrayList<Integer>());
            }
            if(temp.left != null) {
                queue.add(temp.left);
                col.add(currcol - 1);
                min = Math.min(min, currcol - 1);
            }
            if(temp.right != null) {
                queue.add(temp.right);
                col.add(currcol + 1);
                max = Math.max(max, currcol + 1);
            }
            map.get(currcol).add(temp.val);
            map.put(currcol, map.get(currcol));          
        }
        for(int i = min; i <= max; i++) {
            if(map.containsKey(i)){
                res.add(map.get(i));
            }
        }
        return res;
    }
}