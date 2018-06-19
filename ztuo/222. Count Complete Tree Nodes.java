class Solution {
    int height(TreeNode root) {
       if(root == null) return -1;
        else return height(root.left) + 1;
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        int result = 0;
        while(root != null) {
            if(height(root.right) == h - 1) {
                result += 1 << h;
                root = root.right;
            } else {
                result += 1 << (h - 1);
                root = root.left;
            }
            h--;
        }
        return result;
    }
}