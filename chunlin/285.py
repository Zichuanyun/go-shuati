# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderSuccessor(self, root, p):
        """
        :type root: TreeNode
        :type p: TreeNode
        :rtype: TreeNode
        """
        if p.right:
            return self.minValue(p.right)
        successor = None
        while root:
            if root.val > p.val:
                successor = root
                root = root.left
            elif root.val < p.val:
                root = root.right
            else:
                break
        return successor
    def minValue(self, root):
        cur = root
        while cur.left:
            cur = cur.left
        return cur
        
    # Solution 2:
#     def inorderSuccessor(self, root, p):
#         # write your code here
#         successor = None
#         while root:
#             if root.val > p.val:
#                 successor = root
#                 root = root.left
#             else:
#                 root = root.right
#         return successor

        # WA:
        # stack = []
        # cur = root
        # while cur or stack:
        #     while cur:
        #         stack.append(cur)
        #         cur = cur.left
        #     cur = stack.pop
        #     if cur == p and stack:
        #         return stack.pop()
        #     cur = cur.right
        # return None
