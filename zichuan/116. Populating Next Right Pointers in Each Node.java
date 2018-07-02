public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode rightMost = root.left;
        TreeLinkNode leftMost = root.right;
        while (rightMost != null) {
            rightMost.next = leftMost;
            rightMost = rightMost.right;
            leftMost = leftMost.left;
        }
        connect(root.left);
        connect(root.right);
    }
    
    /*
    private TreeLinkNode[] helper(TreeLinkNode root) {
        TreeLinkNode[] most = new TreeLinkNode[] {root, root};
        if (root.left != null) {
            root.left.next = root.right;
            TreeLinkNode[] fromL = helper(root.left);
            TreeLinkNode[] fromR = helper(root.right);
            fromL[1].next = fromR[0];
            most[0] = fromL[0];
            most[1] = fromR[1];
        }
        return most;
    }
    */
}