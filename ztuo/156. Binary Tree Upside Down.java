class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
    TreeNode curr = root;
    TreeNode next = null;
    TreeNode temp = null;
    TreeNode prev = null;
    
    while(curr != null) {
        next = curr.left;
        curr.left = temp;
        temp = curr.right;
        curr.right = prev;
        
        prev = curr;
        curr = next;
    }
    return prev;
    }
}