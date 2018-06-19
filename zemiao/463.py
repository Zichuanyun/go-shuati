class Solution(object):
    def islandPerimeter(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid:
            return 0
        m, n, ans = len(grid), len(grid[0]), 0
        seen = [[0]*n for _ in range(m)]
                
        for a in range(m):
            for b in range(n):
                if seen[a][b] or grid[a][b] == 0:
                    continue
                seen[a][b] = 1

                ans += 4
                if a-1 >= 0:
                    ans -= 1 if grid[a-1][b]==1 else 0
                if a+1 < m:
                    ans -= 1 if grid[a+1][b]==1 else 0
                if b-1 >= 0:
                    ans -= 1 if grid[a][b-1]==1 else 0
                if b+1 < n:
                    ans -= 1 if grid[a][b+1]==1 else 0
        
        return ans
            