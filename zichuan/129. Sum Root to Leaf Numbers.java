class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return sum;
    }
    
    private void helper(TreeNode root, int upper) {
       int curVal = upper * 10 + root.val;
        if (root.left == null && root.right == null) {
           sum += curVal;
       } else {
            if (root.left != null) helper(root.left, curVal);
            if (root.right != null) helper(root.right, curVal);
       }
    }
}