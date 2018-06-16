class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(nums) == 0:
            return [-1,-1]
        if nums[0] == nums[-1]:
            if nums[0] == target:
                return [0,len(nums)-1]
            else:
                return [-1,-1]
        
        def binary(nums, target):
            left, right = 0, len(nums)-1
            while left <= right:
                mid = left+(right-left)/2
                if nums[mid] == target:
                    return mid
                elif nums[mid] < target:
                    left = mid+1
                else:
                    right = mid-1
                
            return left
        
        x = binary(nums, target)
        if x == len(nums) or target != nums[x]:
            return [-1,-1]
        a = self.searchRange(nums[:x],target)
        b = self.searchRange(nums[x+1:],target)
        left = x-(a[1]-a[0]+1) if a[0] != -1 else x
        right = x+(b[1]-b[0]+1) if b[0] != -1 else x
        return [left, right]