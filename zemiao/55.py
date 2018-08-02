class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        left, right = 0,0
        
        while right < len(nums)-1:
            newRight = right
            for i in range(left,right+1):
                newRight = max(newRight, nums[i]+i)
            
            if newRight == right:
                return False
            
            left += 1
            right = newRight
            
        return True