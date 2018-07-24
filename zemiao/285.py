"""
Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
"""


class Solution:
    """
    @param: root: The root of the BST.
    @param: p: You need find the successor node of p.
    @return: Successor of p.
    """
    def inorderSuccessor(self, root, p):
      if not root:
        return None
        
      if p.right:
        node = p.right
        while node.left:
          node = node.left
        return node
        
      parent,pp = None,None
      node = root
      lc = True
      while node != p:
        pp = parent
        parent = node
        lc = p.val < node.val
        node = node.left if lc else node.right
        
      if not parent:
        return None
        
      if lc:
        return parent
      else:
        if not pp or pp.left != parent:
          return None
        return pp 
        