class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root)[0] == 0;
    }
    
    private int[] helper(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        if (left[0] == 1 || right[0] == 1 || Math.abs(left[1] - right[1]) > 1) {
            return new int[] {1, 0};
        }
        
        return new int[] {0, Math.max(left[1], right[1]) + 1};
        
    }
}