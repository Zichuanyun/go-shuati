class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if not nums or len(nums) == 0:
            return list()
        result = list()
        nums.sort()
        self.helper(result, nums, 0, list())
        return result
        
    def helper(self, result, nums, startIndex, subset):
        result.append(list(subset))
        for i in range(startIndex, len(nums)):
            subset.append(nums[i])
            self.helper(result, nums, i + 1, subset)   # startIndex + 1 -> i + 1
            subset.pop()
