# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head:
          return True
        if not head.next:
          return True
        
        # get len
        node, l = head, 0
        while node:
          l += 1
          node = node.next
          
        # reverse latter half
        node, i = head, 0
        while i < (l-1)/2:
          i += 1
          node = node.next
        next, newHead = node.next, node
        while next:
          newNext = next.next
          next.next = newHead
          newHead = next
          next = newNext
          
        # scan
        i = 0
        while i <= (l-1)/2:
          if newHead.val != head.val:
            return False
          i += 1
          newHead = newHead.next
          head = head.next
        return True