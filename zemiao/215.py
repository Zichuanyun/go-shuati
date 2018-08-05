class Solution(object):
    def findKthLargest(self, nums, k):
      """
      :type nums: List[int]
      :type k: int
      :rtype: int
      """        
      def findKth(low,high,k):
        x = nums[high-1]
        i,j = low, high-2
        while i<=j:
          while i<high-1 and nums[i]<=x:
            i += 1
          while j>=low and nums[j]>=x:
            j -= 1
          if i<j:
            nums[i],nums[j] = nums[j],nums[i]
        if k<=j+1:
          return findKth(low,j+1,k)
        elif k >= i+2:
          return findKth(i,high-1,i+(k-1)-(i+1)+1)
        return x
      
      return findKth(0,len(nums),len(nums)-k+1)
        