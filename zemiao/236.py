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
        exist = {}
        
        def getExist(root, val):
          if not root:
            return False
          
          if root.val == val:
            return True

          if (root.val, val) not in exist:
            exist[(root.val, val)] = getExist(root.left,val) or getExist(root.right,val)
          return exist[(root.val, val)] 
        
        node = root
        while node.val != p.val and node.val != q.val:
          pL,qL = getExist(node.left, p.val), getExist(node.left, q.val)
          if pL and qL:
            node = node.left
            continue
          if pL or qL:
            return node
          node = node.right
        return node