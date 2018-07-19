class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums or len(nums) == 0:
            return -1
        start = 0
        end = len(nums) - 1
        while start + 1 < end:
            mid = start + (end - start) / 2
            if nums[mid] == target:
                return mid
            if nums[mid] > nums[-1]:    # check where is mid first
                if target <= nums[-1] or target >= nums[mid]:   # check where's target, in the right side of mid
                    start = mid
                else:
                    end = mid
            else:
                if target <= nums[-1] and target >= nums[mid]:  # check if target is in the right side of mid
                    start = mid
                else:
                    end = mid
        if nums[start] == target:
            return start
        if nums[end] == target:
            return end
        return -1
                    
