class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        if not nums:
            return False

        low, high = 0, len(nums) - 1

        while low <= high:
            while low+1<=high and nums[low+1]==nums[low]:
              low += 1
            while high-1>=low and nums[high-1]==nums[high]:
              high -= 1
            if low+1<=high and nums[low]==nums[high]:
              low += 1
              
            mid = (low + high) / 2
            if target == nums[mid]:
                return True

            if nums[high] >= nums[mid]:
                if nums[mid] <= target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
            else:
                if nums[low] <= target <= nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1

        return False