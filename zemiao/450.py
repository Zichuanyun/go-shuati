# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def deleteNode(self, root, key):
        """
        :type root: TreeNode
        :type key: int
        :rtype: TreeNode
        """
        def find(key):
          parent = None
          node = root
          while node:
            if node.val == key:
              return parent,node
            
            parent = node
            if node.val > key:
              node = node.left
            else:  
              node = node.right
          return None,None
        
        parent,node = find(key)
        if node:
          if node.left:
            l,p = node.left,None
            while l.right:
              p = l
              l = l.right
            if p:
              p.right = l.left
            else:
              node.left = l.left
            node.val = l.val
          else:
            if not parent:
              return node.right
            
            if node == parent.right:
              parent.right = node.right
            else:
              parent.left = node.right
              
        return root
          