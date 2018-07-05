# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
        smaller, greater = None, None
        s_tail, g_tail = None, None
        now = head
        while now:
            if now.val < x:
                if smaller:
                    s_tail.next = now
                    s_tail = now
                else:
                    smaller, s_tail = now, now
            else:
                if greater:
                    g_tail.next = now
                    g_tail = now
                else:
                    greater, g_tail = now, now
            now = now.next
        
        if not smaller or not greater:
            return head
        
        s_tail.next = greater
        g_tail.next = None
        return smaller