# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        res = []
        if not root:
          return res
        
        queue = collections.deque([(root,0)])
        currentLevel = 0
        while queue:
          temp = []
          while queue and queue[0][1] == currentLevel:
            node = queue.popleft()[0]
            temp.append(node.val)
            if node.left:
              queue.append([node.left,currentLevel+1])
            if node.right:
              queue.append([node.right,currentLevel+1])
          res.append(temp)
          currentLevel += 1
        return res