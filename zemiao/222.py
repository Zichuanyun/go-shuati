# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def leftHeight(root):
            ans = 1
            if root.left:
                ans += leftHeight(root.left)
            return ans
        
        def rightHeight(root):
            ans = 1
            if root.right:
                ans += rightHeight(root.right)
            return ans
        
        if not root:
            return 0
        
        l, r = leftHeight(root), rightHeight(root)
        if l == r:
            return 2**l-1
        else:
            if not root.right:
                return 2
            lSub, rSub = leftHeight(root.right), rightHeight(root.right)
            if lSub == rSub:
                # right is full
                return self.countNodes(root.left) + 2**rSub
            else:
                # left is full
                return self.countNodes(root.right) + 2**(l-1)
