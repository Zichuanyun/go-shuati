class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        res = []
        n = len(nums)
        for i in range(n-2):
          if i>0 and nums[i-1]==nums[i]:
            continue
            
          if -nums[i]<2*nums[i+1] or -nums[i]>2*nums[n-1]:
            continue
            
          # Two sum
          l,r = i+1, n-1
          while l<r:
            if l>i+1 and nums[l-1]==nums[l]:
              l += 1
              continue
              
            if r<n-1 and nums[r]==nums[r+1]:
              r -= 1
              continue
            
            if nums[l]+nums[r] == -nums[i]:
              res.append([nums[i],nums[l],nums[r]])
              l,r = l+1,r-1
            elif nums[l]+nums[r] < -nums[i]:
              l += 1
            else:
              r -= 1
            
        return res