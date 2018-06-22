class Solution {
    
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int height = 0;
        int offset = 0;
        int h = getLHeight(root);
        while (root != null) {
            System.out.println("--------------");
            ++height;
            int left = getRHeight(root.left);
            int right = getRHeight(root.right);
            offset = offset << 1;
            if (left == right) {
                root = root.left;
                offset = offset | 0;
                // System.out.println("Go left.");
            } else {
                root = root.right;
                offset = offset | 1;
                // System.out.println("Go right.");
            }
            
            
            // System.out.println("offset: " + offset);
            // System.out.println("height: " + height);
        }
        
        return (1 << height) + offset - 1;
    }
    
    
    private int getRHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getRHeight(root.right) + 1;
    }
    
    private int getLHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getLHeight(root.left) + 1;
    }
}