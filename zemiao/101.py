# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        queue = collections.deque([root])
        while queue:
            newqueue = []
            vals = []
            while queue:
                now = queue.popleft()
                if now.left:
                    newqueue.append(now.left)
                    vals.append(now.left.val)
                else:
                    vals.append(2**10)
                    
                if now.right:
                    newqueue.append(now.right)
                    vals.append(now.right.val)
                else:
                    vals.append(2**10)
                    
            for i in range(len(vals)/2):
                if vals[i] != vals[len(vals)-1-i]:
                    return False
            queue = collections.deque(newqueue)
            
        return True