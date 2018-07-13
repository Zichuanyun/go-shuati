class Node(object):
  def __init__(self, val):
    # smaller is the count of smaller vals in the subtree of self
    self.val = val
    self.left, self.right = None, None
    self.num = 1
    self.smaller = 0

class Solution(object):
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if not nums:
          return []
        res = [0]*len(nums)
        root = Node(nums[-1])
        for i in reversed(range(len(nums)-1)):
          res[i] = self.insert(root, nums[i])
        return res

    def insert(self, node, val):
        if val < node.val:
          node.smaller += 1
          if not node.left:
            node.left = Node(val)
            return 0
          return self.insert(node.left, val)
        elif val > node.val:
          if not node.right:
            node.right = Node(val)
            return node.smaller + node.num
          return self.insert(node.right, val) + node.smaller + node.num
        else:
          node.num += 1
          return node.smaller
            