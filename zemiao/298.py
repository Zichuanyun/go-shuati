"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: the root of binary tree
    @return: the length of the longest consecutive sequence path
    """
    def longestConsecutive2(self, root):
      res = [0]
      
      '''Returns (cons_Len, reversed_cons_Len)'''
      def consecutiveLengths(root):
        if not root:
          return 0,0
        
        consLen, revConsLen = 1,1
        for node in [root.left, root.right]:
          len1,len2 = consecutiveLengths(node)
          if node and abs(node.val-root.val)==1:
            if node.val > root.val:
              consLen = max(consLen,len1+1)
            else:
              revConsLen = max(revConsLen,len2+1)
        res[0] = max(res[0],consLen+revConsLen-1)
        return consLen, revConsLen
        
      if not root:
        return 0
        
      consecutiveLengths(root)
      return res[0]