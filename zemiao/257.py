# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        ans = []
        
        def dfs(temp, node):
            temp += str(node.val) if temp=="" else "->"+str(node.val)
            if not node.left and not node.right:
                ans.append(temp)
            
            if node.left:
                dfs(temp, node.left)
            if node.right:
                dfs(temp, node.right)
        
        if not root:
            return ans
        dfs("",root)
        return ans