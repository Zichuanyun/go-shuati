# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        def lenL(head):
          if not head:
            return 0
          
          node = head
          res = 0
          while node:
            res += 1
            node = node.next
          return res
        
        if lenL(l1)<lenL(l2):
          l1,l2 = l2,l1
         
        head = l1
        while l1:
          if l2:
            l1.val += l2.val
            l2 = l2.next
          if l1.val>9:
            if l1.next:
              l1.next.val += 1
            else:
              l1.next = ListNode(1)
            l1.val = l1.val % 10
        
          l1 = l1.next
          
        return head