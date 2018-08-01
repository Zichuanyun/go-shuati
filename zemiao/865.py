# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def subtreeWithAllDeepest(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        map = {}
        
        def getDepth(root):
            if not root:
                return 0
            
            map[root.val] = max(getDepth(root.left),getDepth(root.right))+1
            return map[root.val]
        
        d = getDepth(root)
        node = root
        layer = 1
        while node:
            leftIsDeepest, rightIsDeepest = False,False
            if node.left and map[node.left.val]==d-layer:
                leftIsDeepest = True
            if node.right and map[node.right.val]==d-layer:
                rightIsDeepest = True
            if leftIsDeepest and rightIsDeepest:
                return node
            
            if leftIsDeepest:
                node = node.left
            elif rightIsDeepest:
                node = node.right
            else:
                return node
            
            layer += 1
                