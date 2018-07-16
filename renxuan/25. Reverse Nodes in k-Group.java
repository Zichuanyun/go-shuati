/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode node = head;
        while(node != null) {
            ++len;
            node = node.next;
        }
        if(k <= 1 || k > len) return head;
        int parts = len / k;
        ListNode newHead = null, nextHead = head, preTail = null;
        node = head;
        while(parts > 0) {
            ListNode prev = null;
            for(int i = 0; i < k; ++i) {
                ListNode next = node.next;
                if(i == k - 1) {
                    nextHead = next;
                }
                node.next = prev;
                prev = node;
                node = next;
            }
            if(newHead == null) newHead = prev;
            head.next = nextHead;
            if(preTail != null) preTail.next = prev;
            preTail = head;
            head = head.next;
            --parts;
        }
        return newHead;
    }
}
