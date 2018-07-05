# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """ 
        if not head:
            return
        
        map = {}
        now, i = head, 0
        while now:
            map[i] = now
            now = now.next
            i += 1
        
        l, r = 0, len(map)-1
        while l+1 < r:
            map[r-1].next = None
            map[l].next = map[r]
            map[r].next = map[l+1]
            l, r = l+1, r-1
