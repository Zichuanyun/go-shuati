class Solution {
    int global_max;
    public int longestConsecutive(TreeNode root) {
        //corner case
        if(root == null) return 0;
        global_max = 0;
        postHelper(root);
        return global_max;
    }
    
    public int postHelper(TreeNode root) {
        if(root == null) return 1;
        int left = postHelper(root.left);
        int right = postHelper(root.right);
        
        boolean flag = false;
        if(root.left != null && root.left.val - root.val == 1) {
            flag = true;
            left++;
        }
        if(root.right != null && root.right.val - root.val == 1) {
            flag = true;
            right++;
        }
        global_max = Math.max(global_max, left);
        global_max = Math.max(global_max, right);
        if(flag) return Math.max(right, left);
        else return 1;
    }
}