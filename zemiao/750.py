class Solution:
    """
    @param grid: the grid
    @return: the number of corner rectangles
    """
    def countCornerRectangles(self, grid):
        # Write your code here
        if not grid:
          return 0
        
        m,n = len(grid),len(grid[0])
        res = 0
        # (i,j) is the left-upper corner of corner rects
        for i in range(m-1):
          for j in range(n-1):
            if grid[i][j] == 0:
              continue
            for x in range(i+1,m):
              for y in range(j+1,n):
                if not grid[x][y]:
                  continue
                if grid[i][y] and grid[x][j]:
                  res += 1
        return res