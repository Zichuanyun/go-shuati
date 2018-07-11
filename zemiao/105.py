# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if len(preorder) == 0:
            return None
        
        # find root index from inorder
        root = preorder[0]
        rootIndex = inorder.index(root)
        
        # call left and right subtree recursively
        rootNode = TreeNode(root)
        rootNode.left = self.buildTree(preorder[1:rootIndex+1], inorder[:rootIndex])
        rootNode.right = self.buildTree(preorder[rootIndex+1:], inorder[rootIndex+1:])
        
        return rootNode