# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if len(inorder) == 0:
          return None
        
        # find root index from inorder
        root = postorder[-1]
        rootIndex = inorder.index(root)
        
        # call left and right subtree recursively
        rootNode = TreeNode(root)
        rootNode.left = self.buildTree(inorder[:rootIndex], postorder[0:rootIndex], )
        rootNode.right = self.buildTree(inorder[rootIndex+1:], postorder[rootIndex:-1])
        
        return rootNode