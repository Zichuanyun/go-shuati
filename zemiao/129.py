# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        ans = 0
        if not root:
            return ans
        
        stack = [(root, root.val)]
        while stack:
            node, temp = stack.pop()
            if node.left:
                stack += [(node.left, temp*10+node.left.val)]
            if node.right:
                stack += [(node.right, temp*10+node.right.val)]
            if not (node.left or node.right):
                ans += temp
        
        return ans