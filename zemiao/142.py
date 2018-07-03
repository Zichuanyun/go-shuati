# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        # Use math, fast ptr traveled 2 times distance slow ptr traveled when they meet.
        # Fast ptr also traveled exactly one cycle more than slow ptr to meet.
        # a+b = d1
        # d2 = d1*2
        # d2 = d1 + loop*n
        # ==> a = n*loop-b
        # ==> slow ans head now has the same distance to cycle start point
        slow = head
        fast = head
        first = True
        while fast and fast.next and (first or slow != fast):
            first = False
            slow = slow.next
            fast = fast.next.next
        if not fast or not fast.next:
            return None

        now = head
        while slow != now:
            slow = slow.next
            now = now.next
        return slow