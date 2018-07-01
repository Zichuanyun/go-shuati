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
        if(head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = sortList(slow.next);
        slow.next = null;
        head = sortList(head);
        head = merge(head, mid);
        return head;
    }
    
    private ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0), newHead = dummy;
        while(first != null && second != null) {
            if(first.val < second.val) {
                dummy.next = first;
                first = first.next;
            }
            else {
                dummy.next = second;
                second = second.next;
            }
            dummy = dummy.next;
        }
        if(first == null) dummy.next = second;
        else dummy.next = first;
        return newHead.next;
    }
}
