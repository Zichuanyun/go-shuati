# Definition for a  binary tree node
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        self.now = root if root else None
        if not root:
            return
        self.enqueueLeft()

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.now != None

    def next(self):
        """
        :rtype: int
        """
        if not self.hasNext():
            return
        res = self.now.val
        if self.now.right:
            self.now = self.now.right
            self.enqueueLeft()
        else:
            self.now = self.stack.pop() if self.stack else None
        return res
    
    def enqueueLeft(self): 
        while self.now.left:
            self.stack.append(self.now)
            self.now = self.now.left

# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())