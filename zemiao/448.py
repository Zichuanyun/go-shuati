class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # Sort
        i, n = 0, len(nums)
        while i < n:
            temp = nums[i]
            while nums[temp-1] != temp:
                next = nums[temp-1]
                nums[temp-1] = temp
                temp = next
            i += 1
            
        res = []
        i = 0
        while i < n:
            if nums[i] != i+1:
                res.append(i+1)
            i += 1
        return res