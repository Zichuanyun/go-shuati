class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
         
        StringBuilder sb = new StringBuilder(String.valueOf(root.val));
        dfs(root,list,sb);
        return list;
    }
    public void dfs(TreeNode root, List<String> list, StringBuilder sb){
        if(root.right == null && root.left == null) {
            list.add(sb.toString());
            return;
        }
        if(root.right != null) dfs(root.right, list, new StringBuilder(sb).append("->" + root.right.val));
        if(root.left != null) dfs(root.left, list, new StringBuilder(sb).append("->" + root.left.val));
    }
}