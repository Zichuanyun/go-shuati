class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode sentinal = dummy;
        for (int i = 0; i < m - 1; ++i) {
            sentinal = sentinal.next;
        }
        ListNode start = sentinal.next;
        ListNode prev = sentinal;
        while (n - m >= 0) {
            ListNode next = start.next;
            start.next = prev;
            prev = start;
            start = next;
            --n;
        }
        sentinal.next.next = start;
        sentinal.next = prev;
        return dummy.next;
    }   
} 