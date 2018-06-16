# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        
        stack = [(root,1)]
        ans = 1
        while stack:
            node, depth = stack.pop()
            ans = max(ans, depth)
            if node.left:
                stack += [(node.left, depth+1)]
            if node.right:
                stack += [(node.right, depth+1)]
        
        return ans