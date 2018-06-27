# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        stack = [root]
        ans = [root.val]
        while stack:
            now = stack.pop()
            while now.left:
                stack.append(now)
                ans.append(now.left.val)
                now = now.left
            while stack and not now.right:
                now = stack.pop()
            if now.right:
                stack.append(now.right)
                ans.append(now.right.val)
                
        return ans
