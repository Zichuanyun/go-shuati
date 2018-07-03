class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode sentinal = dummy;
        for (ListNode head : lists) {
            if (head != null) pq.offer(head);
        }
        while (pq.size() > 0) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
            }
            sentinal.next = node;
            sentinal = sentinal.next;
        }
        return dummy.next;
    }
}