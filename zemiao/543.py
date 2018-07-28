# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        res = [0]
        
        def getDepth(root):
          if not root:
            return 0
          
          leftDepth, rightDepth = getDepth(root.left), getDepth(root.right)
          res[0] = max(res[0], leftDepth+rightDepth)
          return 1+max(leftDepth,rightDepth)
          
        getDepth(root)
        return res[0]