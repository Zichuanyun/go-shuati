# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        def length(head):
          i = 0
          while head:
            i += 1
            head = head.next
          return i
        
        '''Reverses [head:head+len],
        returns (head,tail)'''
        def reverse(head, len):
          if not head:
            return None, None
          if length(head) < len:
            return head, None
          tail, newHead, next = head, head, head.next
          i = 1
          while next and i<len:
            i += 1
            newNext = next.next
            next.next = newHead
            newHead = next
            next = newNext
          tail.next = next
          return newHead, tail
        
        dummy = ListNode(0)
        dummy.next = head
        tail = dummy
        while tail:
          tail.next, tail = reverse(tail.next, k)
        return dummy.next
        