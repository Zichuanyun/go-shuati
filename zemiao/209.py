class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        start, end, n = 0,0,len(nums)
        res = 0
        if not nums:
          return 0
        temp = 0
        while end < n:
          temp += nums[end]
          while temp >= s:
            res = min(end-start+1,res) if res > 0 else end-start+1
            temp -= nums[start]
            start += 1
          end += 1
        return res