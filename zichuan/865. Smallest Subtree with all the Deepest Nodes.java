class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root != null && root.left == null && root.right == null) {
            return root;
        }
        return subtreeWithAllDeepest(root, 0, new int[]{0});
    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root, int depth, int[] max) {
        if(root != null) {
            TreeNode rleft = null;
            TreeNode rRight = null;
            max[0] = Math.max(max[0], depth);
            int[] lMax = new int[]{max[0]};
            int[] rMax = new int[]{max[0]};
            if(root.left != null) {
                rleft = subtreeWithAllDeepest(root.left, depth+1, lMax);
            }
            if(root.right != null) {
               rRight = subtreeWithAllDeepest(root.right, depth+1, rMax);
            }
            max[0] = Math.max(max[0], lMax[0]);
            max[0] = Math.max(max[0], rMax[0]);
            if(rleft == null && rRight == null && depth+1 == max[0]) {
                return root;
            }
            if(lMax[0] > rMax[0]) return rleft;
            else if(lMax[0] < rMax[0]) return rRight;
            else return root;
        } 
        return null;
    }
}
