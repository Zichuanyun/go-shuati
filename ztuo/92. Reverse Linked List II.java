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
        if (m >= n || head == null) {
            return head;
        }
        int counter = 0;
        ListNode pre = null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while(counter < m) {
            if(head == null) {
                return null;
            }
            pre = head;
            head = head.next;
            counter++;
        } 
        ListNode mPre = pre;
        ListNode mNode = head;
        ListNode nNode = head;
        ListNode nPost = head.next;
        while(counter < n) {
            if(nPost == null) {
                return null;
            }
            ListNode temp = nPost.next;
            nPost.next = nNode;
            nNode = nPost;
            nPost = temp;
            counter++;
        }
        mNode.next = nPost;
        mPre.next = nNode;
        
        return dummy.next;
        
    }
}