/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0), smallerCurr = smaller, larger = new ListNode(0), largerCurr = larger;
        while(head != null) {
            if(head.val < x) {
                smallerCurr.next = head;
                smallerCurr = smallerCurr.next;
                head = head.next;
                smallerCurr.next = null;
            }
            else {
                largerCurr.next = new ListNode(head.val);
                largerCurr = largerCurr.next;
                head = head.next;
                largerCurr.next = null;
            }
        }
        smallerCurr.next = larger.next;
        return smaller.next;
    }
}
