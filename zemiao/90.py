class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = [[]]
        counts = collections.defaultdict(int)
        for i in nums:
          counts[i] += 1
        
        for i in counts:
          temp = []
          newRes = list(res)
          for _ in range(counts[i]):
            temp.append(i)
            for r in res:
              newRes.append(r+temp)
          res = newRes
        return res