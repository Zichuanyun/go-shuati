def house_rob_I(nums):
    if len(nums) == 0:
        return 0
    if len(nums) == 1:
        return nums[0]

    dp = [0, 0] # initialize circular buffer

    dp[0] = 0
    dp[1] = nums[0]

    for i in range(2, len(nums)+1):
        dp[i%2] = max(dp[(i-2)%2] + nums[i-1], dp[(i-1)%2])

    return dp[len(nums)%2]


class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        """
        idea: use the same idea as house robber I, except this time, we only have 2 cases, either we rob the last house or not rob the first house
        assuming the solution to house robber I is f(), then choosing to rob the first house would be nums[0] + f(nums[2:-1]), and not choosing to rob the first house would be f(nums[1:])
        """
        if len(nums) == 0:
            return 0
        elif len(nums) == 1:
            return nums[0]
        
        return max(nums[0] + house_rob_I(nums[2:-1]), house_rob_I(nums[1:]) )
        
