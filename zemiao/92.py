# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        if not head or m == n:
            return head
        
        reversedHead, broke = head, None
        nextNode = head.next
        nextIndex = 0
        while nextNode:
            nextIndex += 1
            if m<=nextIndex<n:
                temp = nextNode
                nextNode = nextNode.next
                temp.next = reversedHead
                reversedHead = temp
            elif nextIndex<m:
                broke = reversedHead
                reversedHead = reversedHead.next
                nextNode = nextNode.next
            else:
                break
        
        if broke:
            broke.next.next = nextNode
            broke.next = reversedHead
        else:
            head.next = nextNode
            head = reversedHead
        return head