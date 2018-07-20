class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix:
          return 0
        
        m,n = len(matrix),len(matrix[0])
        dp = [int(c) for c in matrix[0]]
        res = max(dp)
        for i in range(1,m):
          for j in range(n):
            if matrix[i][j]=='0':
              dp[j] = 0
              continue
              
            # new dp[j] should >= 1
            if j==0 or matrix[i][j-1]=='0':
              dp[j] = 1
              res = max(res, 1)
              continue
            a,b = dp[j-1],dp[j]
            if a != b:
              dp[j] = min(a,b)+1
            else:
              dp[j] = a + int(matrix[i-a][j-a])
            res = max(res, dp[j]**2)
        return res
          