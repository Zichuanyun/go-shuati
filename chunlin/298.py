# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    max_depth = 0
    def longestConsecutive(self, root):     # originally not using helper, then find out that main func needs to return global
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        self.helper(root);
        return self.max_depth;
    def helper(self, root):                 # helper need to return local max, not final global max value
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        left = self.helper(root.left)
        right = self.helper(root.right)
        if not root.left or root.val + 1 != root.left.val:
            left = 0
        if not root.right or root.val + 1 != root.right.val:
            right = 0
        depth = max(left, right) + 1
        if depth > self.max_depth:
            self.max_depth = depth
        return depth
