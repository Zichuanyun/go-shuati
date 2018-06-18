class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0
        m,n = len(grid), len(grid[0])
        seen = [[0]*n for _ in range(m)]
        count = [0]
        
        def dfs(a,b,isolated):
            if grid[a][b]=='0' or seen[a][b]:
                return
            
            seen[a][b] = 1
            count[0] += 1 if isolated else 0
            
            # Flood
            if a+1 < m:
                dfs(a+1,b,False)
            if b+1 < n:
                dfs(a,b+1,False)
            if a-1 >=0:
                dfs(a-1,b,False)
            if b-1 >=0:
                dfs(a,b-1,False)
                
        for i in range(m):
            for j in range(n):
                dfs(i,j,True)
        return count[0]