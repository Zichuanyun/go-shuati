# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if not root:
          return None
        if (root.val-p.val)*(root.val-q.val) <=0:
          return root
        if root.val < p.val:
          return self.lowestCommonAncestor(root.right, p,q)
        return self.lowestCommonAncestor(root.left, p,q)