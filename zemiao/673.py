class Solution(object):
    def findNumberOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
          return 0
        
        n = len(nums)
        map = [(1,1) for _ in range(n)] # key -> maxLen, count
        for i in range(1,n):
          x = nums[i]
          maxLen, newCount = 0,1
          for j in range(i):
            if nums[j] >= x:
              continue
              
            l, count = map[j]
            if l>maxLen:
              maxLen, newCount = l, count
            elif l==maxLen:
              newCount += count
          
          map[i] = (maxLen+1,newCount)
          
        maxLen, res = 0, 0
        for l,count in map:
          if l>maxLen:
            maxLen, res = l, count
          elif l==maxLen:
            res += count
        return res