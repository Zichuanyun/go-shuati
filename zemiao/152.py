class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        def maxProductWithoutZero(nums):
          if not nums:
            return -1
          n = len(nums)
          dp = [1]*(n+1)
          for i in range(1,n+1):
            dp[i] = dp[i-1]*nums[i-1]

          posMin, negMin = 1,1
          res = nums[0]
          for i in range(1,n+1):
            if dp[i]>0:
              res = max(res, dp[i]/posMin)
              posMin = min(posMin,dp[i])
            else:
              res = max(res, dp[i]/negMin)
              negMin = max(negMin,dp[i]) if negMin<0 else dp[i]
          return res
        
        for i in range(len(nums)):
          if nums[i]==0:
            return max(0,maxProductWithoutZero(nums[:i]),self.maxProduct(nums[i+1:]))
        return maxProductWithoutZero(nums)