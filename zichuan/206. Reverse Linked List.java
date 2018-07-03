class Solution {
    // recursive
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;
        return head;
    }
}