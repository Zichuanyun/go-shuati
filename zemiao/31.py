class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        i = 0
        for i in reversed(range(n)):
            if i==0 or nums[i-1]>=nums[i]:
                continue
            
            k = n-1
            for j in reversed(range(i,n)):
                if nums[j] > nums[i-1]:
                    k = j
                    break
            
            nums[i-1],nums[k] = nums[k],nums[i-1]
            break
            
        # At this point, nums[i:] is still reversely sorted.
        # Therefore, just reverse it to minimize it.
        l,r = i,n-1
        while l<r:
            nums[l],nums[r]=nums[r],nums[l]
            l += 1
            r -= 1
