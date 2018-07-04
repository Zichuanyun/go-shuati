# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        l1 = self.getLen(headA)
        l2 = self.getLen(headB)
        
        lon = headA if l1 > l2 else headB
        short = headA if lon == headB else headB
        
        diff = abs(l2-l1)
                
        while diff:
            lon = lon.next
            diff -=1
        
        while lon != short:
            lon = lon.next
            short = short.next
        
        return lon
        
        
    def getLen(self, head):
        i = 0 
        while head:
            i += 1
            head = head.next
        return i