class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left, right = 0, len(nums)-1
        while left<=right:
            mid = left+(right-left)/2
            if nums[mid] == target:
                return mid
            if nums[right]>=nums[mid] and nums[left]<=nums[mid]:
                # ordinary binary search
                if nums[mid] < target:
                    left = mid+1
                else:
                    right = mid-1
            elif nums[right]<nums[mid]:
                if nums[mid] < target or target < nums[left]:
                    left = mid+1
                else:
                    right = mid-1
            else:
                if nums[mid] > target or target > nums[right]:
                    right = mid-1
                else:
                    left = mid+1
            
        return -1