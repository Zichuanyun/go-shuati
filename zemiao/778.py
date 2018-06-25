class Solution(object):
    def swimInWater(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        
        heap = [(grid[0][0],0,0)]
        visited = set()
        res, n = 0, len(grid)
        while heap:
            source, a, b = heapq.heappop(heap)
            visited.add(source)
            res = max(res, source)
            if (a,b) == (n-1,n-1):
                return res
            for i,j in [(0,1),(1,0),(0,-1),(-1,0)]:
                if 0 <= a+i < n and 0 <= b+j < n:
                    if grid[a+i][b+j] in visited:
                        continue
                    heapq.heappush(heap, (grid[a+i][b+j],a+i,b+j))
            
        return 0
        
        # bottle = [2**10]
        # map = {}
        # m, n = len(grid[0]), len(grid)

        # def reachable(a,b,limit,visited,dp):
        #     if visited[a][b]:
        #         return False
        #     if (a,b) in dp:
        #         return dp[(a,b)]
        #     if grid[a][b] > limit:
        #         return False
        #     if (a,b) == (0,0):
        #         return True

        #     visited[a][b] = 1
        #     dp[(a,b)] = False

        #     if a-1 >=0 and reachable(a-1,b,limit,visited,dp):
        #         dp[(a,b)] = True
        #     if b-1 >=0 and reachable(a,b-1,limit,visited,dp):
        #         dp[(a,b)] = True
        #     if a+1 < m and reachable(a+1,b,limit,visited,dp):
        #         dp[(a,b)] = True
        #     if b+1 < n and reachable(a,b+1,limit,visited,dp):
        #         dp[(a,b)] = True

        #     visited[a][b] = 0
        #     return dp[(a,b)]

        # l, r = grid[0][0], n*n-1
        # while l<=r:
        #     visited = [[0]*m for _ in range(n)]
        #     dp ={}
        #     mid = l + (r-l)/2
        #     if reachable(m-1,n-1,mid,visited,dp):
        #         r = mid - 1
        #     else:
        #         l = mid + 1
        # return l