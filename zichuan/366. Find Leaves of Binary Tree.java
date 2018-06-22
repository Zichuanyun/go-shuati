class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root);
        return res;
    }
    
    private int helper(List<List<Integer>> res, TreeNode root) {
        if (root == null) return 0;
        int level = Math.max(helper(res, root.left), helper(res, root.right));
        if (res.size() < level + 1) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        return level + 1;
    }
}