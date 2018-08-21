# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if not head:
            return None
        
        index = {}
        newNodes = {}
        newHead = RandomListNode(head.label)
        tail = head
        newTail = newHead
        count = 0
        while tail:
            if count > 0:
                newTail.next = RandomListNode(tail.label)
                newTail = newTail.next
               
            index[tail] = count
            newNodes[count] = newTail
            tail = tail.next
            count += 1
        
        node = head
        newNode = newHead
        while node:
            if node.random:
                newNode.random = newNodes[index[node.random]]
            node = node.next
            newNode = newNode.next
        return newHead
            