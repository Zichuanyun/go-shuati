"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
Definition of Doubly-ListNode
class DoublyListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = self.prev = next
"""


class Solution:
    """
    @param: root: The root of tree
    @return: the head of doubly list node
    """
    def bstToDoublyList(self, root):
        if not root:
            return None
            
        return self.helper(root)[0]
    
    def helper(self, root):
        if not root:
            return None,None
        
        node = DoublyListNode(root.val)
        head, tail = node, node
        if root.left:
            head,tail = self.helper(root.left)
            tail.next = node
            node.prev = tail
            tail = node
        if root.right:
            rhead, rtail = self.helper(root.right)
            tail.next = rhead
            rhead.prev = tail
            tail = rtail
        
        return head,tail