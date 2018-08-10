class Solution(object):
    def PredictTheWinner(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        dp = {}
        
        def maxProfit(begin,end):
          if (begin,end) in dp:
            return dp[(begin,end)]
          
          if begin>=end:
            return 0
          
          if begin+1==end:
            return nums[begin]
          
          r1 = nums[begin]-maxProfit(begin+1,end)
          r2 = nums[end-1]-maxProfit(begin,end-1)
          dp[(begin,end)] = max(r1,r2)
          return dp[(begin,end)]
        
        return maxProfit(0,len(nums))>=0