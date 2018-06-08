class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        exist = {}
        for i in range(len(nums)):
            if target-nums[i] in exist:
                return [exist[target-nums[i]], i]
            exist[nums[i]] = i
        
        return [0,0]
