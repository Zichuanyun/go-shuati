public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null || fast.next == null) return null;
            if (slow == fast) break;
        } while (true);
            
        while (head != slow) {
            slow = slow.next;
            head = head.next;
        }
        return head;
    }
}