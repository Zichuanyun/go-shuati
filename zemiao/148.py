# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        def merge(head1, head2):
            if head1.val > head2.val:
                head1, head2 = head2, head1
            head = head1
            tmp1, tmp2 = head1, head2
            
            while tmp2:
                while tmp1.next and tmp1.next.val <= tmp2.val:
                    tmp1 = tmp1.next
                next1 = tmp1.next
                tmp1.next = tmp2
                tmp1, tmp2 = tmp2, next1
                
            return head
        
        if not head or not head.next:
            return head
        
        tmp, count = head, 0
        while tmp:
            tmp = tmp.next
            count += 1
            
        tmp, i = head, 0
        while i < count/2-1:
            tmp = tmp.next
            i += 1
        split = tmp.next
        tmp.next = None
        
        head = self.sortList(head)
        split = self.sortList(split)
        
        return merge(head, split)