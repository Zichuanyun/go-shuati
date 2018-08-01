class Solution(object):
    def orderOfLargestPlusSign(self, N, mines):
        """
        :type N: int
        :type mines: List[List[int]]
        :rtype: int
        """
        grid = [[1]*N for _ in range(N)]
        for mine in mines:
            grid[mine[0]][mine[1]] = 0
            
        dpL = [[N]*N for _ in range(N)]
        dpR = [[N]*N for _ in range(N)]
        dpU = [[N]*N for _ in range(N)]
        dpD = [[N]*N for _ in range(N)]

        for i in range(N):
            for j in reversed(range(N)):
                right = 1+(dpR[i][j+1] if j+1<N else 0)
                down = 1+(dpD[j+1][i] if j+1<N else 0)
                left = 1+(dpL[i][N-1-j-1] if N-1-j>0 else 0)
                up = 1+(dpU[N-1-j-1][i] if N-1-j>0 else 0)
                
                dpR[i][j] = right if grid[i][j] else 0
                dpL[i][N-1-j] = left if grid[i][N-1-j] else 0
                dpD[j][i] = down if grid[j][i] else 0
                dpU[N-1-j][i] = up if grid[N-1-j][i] else 0
            
        res = 0
        for i in range(N):
            for j in range(N):
                res = max(res,min(dpL[i][j],dpR[i][j],dpU[i][j],dpD[i][j]))
        return res