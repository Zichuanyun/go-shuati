from collections import defaultdict

class Solution(object):
    def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        if not nums:
          return 0
        
        n = len(nums)
        m = [defaultdict(int) for _ in range(n)]
        m[n-1][nums[n-1]] += 1
        m[n-1][-nums[n-1]] += 1
        for i in reversed(range(n-1)):
          x = nums[i]
          for val in m[i+1]:
            times = m[i+1][val]
            m[i][val+x] += times
            m[i][val-x] += times
        return m[0][S]