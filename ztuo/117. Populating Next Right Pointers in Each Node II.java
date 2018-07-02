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
        while(root != null) {
            TreeLinkNode temp = new TreeLinkNode(0); // use temp to store the first element of the lvl
            TreeLinkNode current = temp; //use current to traverse through the lvl
            while(root != null) {
                if(root.left != null) {
                    current.next = root.left;
                    current = current.next;
                }
                if(root.right != null) {
                    current.next = root.right;
                    current = current.next;
                }
                root = root.next;
            }
            root = temp.next;            
        }
    }
}