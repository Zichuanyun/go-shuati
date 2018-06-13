class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        # dp[i][j] is the max coins of ballon i+1...j-1
        # by adding a ballon to left/ right of nums,
        # the ans is dp[0][n-1]
        nums = [1] + nums + [1]
        n = len(nums)
        dp = [[0] * n for _ in range(n)]

        def calculate(i, j):
            if dp[i][j]:
                # in memory
                return dp[i][j]
            
            if j == i+1: 
                #(i,j) is empty
                return 0
            
            coins = 0
            for k in range(i+1, j): 
                # k is the last balloon to explode
                # notice i < k < j, so balloon i/j are not exploded yet
                coins = max(coins, nums[i] * nums[k] * nums[j] + calculate(i, k) + calculate(k, j))
            dp[i][j] = coins
            return coins

        return calculate(0, n-1)