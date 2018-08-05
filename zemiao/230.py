# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        count = {}
        def getCount(root):
          if not root:
            return 0
          c1 = getCount(root.left)
          c2 = getCount(root.right)
          count[root.val] = c1+c2+1
          return count[root.val]
        
        res = -1
        node = root
        getCount(root)
        while res < 0:
          if node.left and count[node.left.val]>=k:
            node = node.left
            continue
          elif (not node.left and k==1) or (node.left and count[node.left.val]==k-1):
            res = node.val
            break
          else:
            k -= count[node.val] - count[node.right.val]
            node = node.right
        return res