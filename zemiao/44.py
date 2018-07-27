class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        # p[j]=='?' ==> dp[i][j] = dp[i-1][j-1]
        # p[j]=='*' ==> dp[i][j] = dp[k][j-1], k=0...i 
        #   NOTE: dp[i-1][j] includes k=0...i-1
        m,n = len(s),len(p)
        dp = [[False for _ in range(n+1)] for _ in range(m+1)]
        dp[0][0] = True
        for i in range(0,m+1):
          for j in range(1,n+1):
            if j == 0:
              continue
              
            if i == 0:
              dp[i][j] = dp[i][j-1] and p[j-1]=='*'
              continue
              
            if p[j-1]=='?':
              dp[i][j] = dp[i-1][j-1]
            elif p[j-1]=='*':
              dp[i][j] = dp[i][j-1] or dp[i-1][j-1] or dp[i-1][j]
            else:
              dp[i][j] = dp[i-1][j-1] and s[i-1] == p[j-1]
        return dp[m][n]