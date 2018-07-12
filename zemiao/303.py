class NumArray(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.sums = [0]
        sum = 0
        self.n = len(nums)
        for i in nums:
          sum += i
          self.sums.append(sum)

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        if i < 0 or j >=self.n:
          return 0
        return self.sums[j+1]-self.sums[i]

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)