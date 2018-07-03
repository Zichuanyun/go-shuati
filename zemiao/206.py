# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return head
        
        reversedHead = head
        nextNode = head.next
        while nextNode:
            temp = nextNode
            nextNode = nextNode.next
            temp.next = reversedHead
            reversedHead = temp
        
        head.next = None
        return reversedHead