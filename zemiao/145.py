# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        stack = [root]
        ans = []
        added = set()
        while stack:
            now = stack.pop()
            leftDone = not now.left or now.left in added
            while not leftDone:
                stack.append(now)
                now = now.left
                leftDone = not now.left or now.left in added
                
            rightDone = not now.right or now.right in added
            if not rightDone:
                stack.append(now)
                stack.append(now.right)
            else:
                ans.append(now.val)
                added.add(now)
                
        return ans
            