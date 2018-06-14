class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        """
        let dp[i] be the largest amount that can be obtained from the first i houses, and it can be either including the i-th house or without the i-th house
        then dp[i+1] = max(dp[i-1] + nums[i+1], dp[i])
        """
        
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        
        dp = [0] * (len(nums) + 1)
        
        dp[0] = 0
        dp[1] = nums[0]
        
        for i in range(2, len(nums)+1):
            dp[i] = max(dp[i-2] + nums[i-1], dp[i-1])
            
        return dp[len(nums)]
        

        
        
