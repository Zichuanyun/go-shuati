class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = list(nums)
        n = len(nums)
        for i in range(n):
          nums[i] *= nums[i-1] if i>0 else 1
          res[n-1-i] *= res[n-i] if i>0 else 1
        temp = 1
        print(nums, res)
        for i in range(n):
          newR = temp*(res[i+1] if i<n-1 else 1)
          temp = nums[i]
          res[i] = newR
        return res