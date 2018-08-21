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
        //corner case
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode sentinal = new ListNode(0);
        ListNode res = sentinal;
        
        int forward = 0;
        while(l1 != null || l2 != null) {
            int sum = 0;
            
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            sum += forward;
            
            if(sum >= 10) {
                sum -= 10;
                forward = 1;
            } else {
                forward = 0;
            }
            
            res.next = new ListNode(sum);
            res = res.next;
        }
        
        if(forward != 0) {
            res.next = new ListNode(1);
        }
        
        return sentinal.next;
    }   
}
