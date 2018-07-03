# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        heap = []
        for i in lists:
            if i:
                heapq.heappush(heap, (i.val, i))
        
        head, tail = None, None
        while heap:
            val, now = heapq.heappop(heap)
            if not head:
                head = now
                tail = head
            else:
                tail.next = now
                tail = now
            if now.next:
                heapq.heappush(heap, (now.next.val, now.next))
        
        return head