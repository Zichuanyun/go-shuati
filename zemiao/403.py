class Solution(object):
    def canCross(self, stones):
        """
        :type stones: List[int]
        :rtype: bool
        """
        dp = set()
        stoneExist = {}
        n = len(stones)
        for i in range(n):
          stoneExist[stones[i]] = i
        
        stack = [(0,0)]
        while stack:
          i,k = stack.pop()
          for j in [k-1,k,k+1]:
            if j < 1:
              continue
            
            if i+j not in stoneExist:
              continue
            
            if i+j == stones[-1]:
              return True
            
            next = i+j
            if (next,j) in dp:
              continue
            
            dp.add((next,j))
            stack.append((next,j))
        
        return False