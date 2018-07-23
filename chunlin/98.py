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
        (isValid, _, _) = self.helper(root)
        return isValid
    
    def helper(self, root):
        """
        :rtype: (bool, int, int)  # isValid, max, min
        """
        if not root:
            return (True, -sys.maxint-1, sys.maxint)
        left = self.helper(root.left)
        right = self.helper(root.right)
        if not left[0] or not right[0]:
            return (False, 0, 0)
        if (root.left and left[1] >= root.val) or (root.right and right[2] <= root.val):      # > < -> >= <=
            return (False, 0, 0)
        return (True, max(root.val, right[1]), min(root.val, left[2]))      # add min/max to update values from leaf nodes
        # if left[0] and right[0] and root.val > left[1] and root.val < right[2]:
        #     return (True, right[1], left[2])
        # else:
        #     return (False, 0, 0)
