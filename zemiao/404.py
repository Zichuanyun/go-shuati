# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def sumLeftLeaves(root, isLeftChild):
          if not root:
            return 0

          if not root.left and not root.right:
            return root.val if isLeftChild else 0

          return sumLeftLeaves(root.left, True) + sumLeftLeaves(root.right, False)
      
        return sumLeftLeaves(root,False)