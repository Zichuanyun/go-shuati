/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;
        Queue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list : lists) {
            if(list != null) q.offer(list);
        }
        ListNode dummy = new ListNode(0), curr = dummy;
        while(!q.isEmpty()) {
            ListNode top = q.poll();
            if(top.next != null) q.offer(top.next);
            curr = curr.next = top;
        }
        return dummy.next;
    }
}
