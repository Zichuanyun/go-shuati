class Solution {
    int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return globalMax;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int upper = Math.max(root.val, Math.max(right + root.val, left + root.val));
        int max = Math.max(upper, root.val + left + right);
        globalMax = Math.max(max, globalMax);
        return upper;
    }
}