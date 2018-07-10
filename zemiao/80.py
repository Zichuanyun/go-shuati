class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        i, n, temp = 0, len(nums), 0
        while i < n:
            if i > 0 and nums[i] == nums[i-1]:
                temp += 1
            else:
                temp = 0
            
            if temp < 2:
                nums[res] = nums[i]
                res += 1
            i += 1
                
        return res
                
        