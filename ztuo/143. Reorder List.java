/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)  return;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode preMid = slow;
        ListNode mid = slow.next;
        
        //reverse the second half
        while(mid.next != null) {
            ListNode current=mid.next;
            mid.next=current.next;
            current.next=preMid.next;
            preMid.next=current;
        }
        
        ListNode l1 = head;
        ListNode l2 = preMid.next;
        //patch the two parts together
        while(l1 != preMid) {
            preMid.next = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
            l2 = preMid.next;
        }
    }
}