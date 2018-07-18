# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        valid = [True]
        
        def getInOrder(root):
          if not root:
            return []
          res = [root.val, root.val]
          if root.left:
            left = getInOrder(root.left)
            if valid[0] and left[-1]<root.val:
              res = [left[0],res[1]]
            else:
              valid[0] = False
              return
          if root.right:
            right = getInOrder(root.right)
            if valid[0] and right[0]>root.val:
              res = [res[0], right[-1]]
            else:
              valid[0] = False
              return
          return res
        
        getInOrder(root)
        return valid[0]
        
        