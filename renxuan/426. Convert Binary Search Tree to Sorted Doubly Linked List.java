/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */

public class Solution {
    public DoublyListNode bstToDoublyList(TreeNode root) {
        DoublyListNode head = new DoublyListNode(0), tail = head;
        Stack<TreeNode> s = new Stack<>();
        while(root != null) {
            s.push(root);
            root = root.left;
        }
        while(!s.empty()) {
            TreeNode top = s.pop();
            tail.next = new DoublyListNode(top.val);
            tail.next.prev = tail;
            tail = tail.next;
            top = top.right;
            while(top != null) {
                s.push(top);
                top = top.left;
            }
        }
        return head.next;
    }
}
