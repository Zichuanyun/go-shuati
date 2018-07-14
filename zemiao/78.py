class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        n = len(nums)
        map = [0]*n
        res = []
        
        def dfs(begin):
          if begin == n:
            res.append([nums[i] for i in range(n) if map[i]])
            return
          
          dfs(begin+1)
          map[begin] = 1
          dfs(begin+1)
          map[begin] = 0
        
        dfs(0)
        return res