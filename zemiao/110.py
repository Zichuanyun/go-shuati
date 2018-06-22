# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def balancedDepth(root):
            if not root:
                return 0
            left = 0 if not root.left else balancedDepth(root.left)
            right = 0 if not root.right else balancedDepth(root.right)
            if left == -1 or right == -1 or abs(left-right) > 1:
                return -1
            return max(left,right)+1
        
        return balancedDepth(root) != -1