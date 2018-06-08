class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        
        dp = [0 for i in range(len(nums))]
        dp[-1], dp[-2] = nums[-1], max(nums[-1], nums[-2])
        for i in reversed(range(len(nums)-2)):
            dp[i] = max(dp[i+1], nums[i]+dp[i+2])
        
        return dp[0]
            
        
        