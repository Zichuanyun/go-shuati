# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return list()
        result = list()
        q = deque()
        q.append(root)
        while q:
            level_size = len(q)
            level_list = list()
            for i in range(level_size):
                cur = q.popleft()
                level_list.append(cur.val)
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            result.append(level_list)
        return result
