class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """        
        left, right = 0, len(nums)-1
        while left <= right:
            if left+1>=right:
                return min(nums[left],nums[right])
            
            # len(nums) > 2
            mid = left + (right-left)/2
            if nums[left] <= nums[mid] and nums[mid] <= nums[right]:
                # ordinary bianry
                return nums[left]
            elif nums[left] > nums[mid]:
                right = mid
            else:
                left = mid+1
            
        return 0