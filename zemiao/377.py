class Solution(object):
    def combinationSum4(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """        
        dp = {}
        
        def dfs(s):
          if s in dp:
            return dp[s]
          
          res = 0
          if s == 0:
            return 1
          if s<0:
            return res
          
          for i in nums:
            if s-i < 0:
              break
            res += dfs(s-i)
          dp[s] = res
          return res
        
        nums.sort()
        return dfs(target)