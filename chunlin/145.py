# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = list()
        stack = list()
        prev = None
        cur = root
        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left
            cur = stack[-1]
            if not cur.right or prev == cur.right:
                result.append(cur.val)
                stack.pop()
                prev = cur
                cur = None
            else:
                cur = cur.right     # wrong: stack.append(cur.right)
        return result
