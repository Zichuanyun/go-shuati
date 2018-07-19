class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if not nums or len(nums) == 0:
            return list()
        result = list()
        nums.sort()
        self.helper(nums, 0, list(), result)
        return result
        
    def helper(self, nums, startIndex, subset, result):
        result.append(list(subset))
        for i in range(startIndex, len(nums)):
            if i != startIndex and nums[i] == nums[i-1]: # nums[i] != nums[startIndex]:
                continue
            subset.append(nums[i])
            self.helper(nums, i + 1, subset, result)
            subset.pop()
