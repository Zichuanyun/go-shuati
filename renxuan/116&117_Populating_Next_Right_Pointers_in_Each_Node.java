/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0), pre = dummy;
        while(root != null) {
            if(root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if(root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if(root == null) {
                root = dummy.next;
                dummy.next = null;
                pre = dummy;
            }
        }
    }
}
