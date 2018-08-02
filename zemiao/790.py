class Solution(object):
    def numTilings(self, N):
        """
        :type N: int
        :rtype: int
        """
        dp = [0]*(max(N,2)+1)
        dp[0] = 1
        dp[1] = 1
        dp[2] = 2
        numTromino = 0
        for i in range(3,N+1):
          numTromino += 2*dp[i-3]
          dp[i] = (dp[i-1]+dp[i-2]+numTromino) % (10**9+7)
        return dp[N]