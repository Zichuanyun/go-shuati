/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0) return null;
        if(inorder.length == 1) return new TreeNode(inorder[0]);
        int rootIdx = 0;
        while(inorder[rootIdx] != postorder[postorder.length-1]) ++rootIdx;
        TreeNode root = new TreeNode(inorder[rootIdx]);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, rootIdx), Arrays.copyOfRange(postorder, 0, rootIdx));    
        root.right = buildTree(Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length), Arrays.copyOfRange(postorder, rootIdx, postorder.length - 1));
        return root;
    }
}
