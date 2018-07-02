/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
       if (head == null || head.next == null)
        return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);        
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
          if (l1.val < l2.val) {
            temp.next = l1;
            l1 = l1.next;
          } else {
            temp.next = l2;
            l2 = l2.next;
          }
          temp = temp.next;
        }
        if(l1 != null) {
            temp.next = l1;
        }
        if(l2 != null) {
            temp.next = l2;
        }
        return head.next;
    }
}