class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        map = {}
        map[0] = -1
        res = 0
        n = len(nums)
        count0, count1 = 0,0
        for i in range(n):
          if nums[i]==1:
            count1 += 1
          else:
            count0 += 1
            
          x = count1 - count0
          if x not in map:
            map[x] = i
          else:
            res = max(res, i-map[x])
        return res