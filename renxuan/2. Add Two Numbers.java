/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0), ret = res;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int sum = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            carry = sum / 10;
            ListNode curr = new ListNode(sum % 10);
            res.next = curr;
            res = res.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return ret.next;
    }
}
