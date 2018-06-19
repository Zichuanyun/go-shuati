class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        return helper(root);
    }
    
    private List<String> helper(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root.left == null && root.right == null) {
            list.add(Integer.toString(root.val));
            return list;
        }
        
        if (root.left != null) {
            for (String str : helper(root.left)) {
                list.add(Integer.toString(root.val) + "->" + str);
            }
        }
        
        if (root.right != null) {
            for (String str : helper(root.right)) {
                list.add(Integer.toString(root.val) + "->" + str);
            }
        }
        
        return list;
    }
}