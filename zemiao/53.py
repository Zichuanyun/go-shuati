class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        dp = [0]*(n+1)
        for i in range(1,n+1):
          dp[i] = dp[i-1]+nums[i-1]
        
        res, m = nums[0],0
        for i in range(1,n+1):
          res = max(res, dp[i]-m)
          m = min(m,dp[i])
        return res