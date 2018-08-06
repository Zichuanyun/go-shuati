from bisect import bisect_left

class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        seq = []
        res = 0
        for x in nums:
          i = bisect_left(seq,x)
          if i<len(seq):
            seq[i] = x
          else:
            seq.append(x)
            res += 1
        return res