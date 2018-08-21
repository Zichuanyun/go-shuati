/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode curr = head;
        while(curr != null) {
            RandomListNode next = curr.next;
            RandomListNode newNode = new RandomListNode(curr.label);
            newNode.next = next;
            curr.next = newNode;
            curr = next;
        }
        curr = head;
        while(curr != null) {
            RandomListNode copy = curr.next, next = copy.next;
            RandomListNode random = curr.random;
            if(random != null) copy.random = random.next;
            curr = next;
        }
        RandomListNode newHead = head.next, copy = newHead;
        curr = head;
        while(curr != null) {
            RandomListNode next = copy.next;
            curr.next = next;
            copy.next = (next == null) ? null : next.next;
            curr = curr.next;
            copy = copy.next;
        }
        return newHead;
    }
}
