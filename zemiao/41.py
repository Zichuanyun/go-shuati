class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # adjust [nums]
        for i in range(len(nums)):
            num = nums[i]
            target = num-1
            while num > 0 and target < len(nums) and nums[target] != num:
                nums[target], num = num, nums[target]
                target = num-1
        
        # find min
        for i in range(len(nums)):
            if nums[i] != i+1:
                return i+1
            
        return len(nums)+1
                