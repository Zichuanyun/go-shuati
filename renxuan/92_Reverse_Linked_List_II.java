/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;
        for(int i = 1; i < m; ++i) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        for(int i = m; i < n; ++i) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }
}
