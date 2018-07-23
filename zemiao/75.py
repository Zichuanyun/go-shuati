class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if not nums:
          return
        
        l,ll,r = 0,0,len(nums)-1
        #[0,2,0,1,2]
        while ll < r:
          while nums[l]==0:
            l += 1
            if l == r:
              return
          ll = l
          while nums[ll]!=2:
            ll += 1
            if nums[ll]==0:
              nums[l],nums[ll] = nums[ll],nums[l]
              l += 1
            if ll == r:
              return
          while nums[r]==2:
            r -= 1
            if r <= ll:
              return
          nums[ll],nums[r] = nums[r],nums[ll]