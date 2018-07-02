class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = new ListNode(0), slow = new ListNode(0);
        fast.next = head;
        slow.next = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(fast);
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode s = l; // s for sentinal
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                s.next = l2;
                l2 = l2.next;
            } else {
                s.next = l1;
                l1 = l1.next;
            }
            s = s.next;
        }
        if (l1 == null) s.next = l2;
        if (l2 == null) s.next = l1;
        return l.next;
    }
}