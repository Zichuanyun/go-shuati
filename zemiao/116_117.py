# Definition for binary tree with next pointer.
# class TreeLinkNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):
        if not root:
            return
        childrenLayerStart = TreeLinkNode(0)
        while root:
            childrenLayerStart.next = None
            tmp = childrenLayerStart
            while root:
                if root.left:
                    tmp.next = root.left
                    tmp = tmp.next
                if root.right:
                    tmp.next = root.right
                    tmp = tmp.next
                root = root.next
            root = childrenLayerStart.next