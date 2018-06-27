class Solution(object):
    def cutOffTree(self, forest):
        """
        :type forest: List[List[int]]
        :rtype: int
        """
        heap = []
        m,n = len(forest),len(forest[0])
        for a in range(m):
            for b in range(n):
                if forest[a][b] not in [0,1]:
                    heap.append((forest[a][b],a,b))
        heap.sort()

        step = 0
        x,y = 0,0
        for _,nextX,nextY in heap:
            # find distance to next
            queue = collections.deque([(x,y,0)])
            visited = {(x,y)}
            while queue:
                a,b,dist = queue.popleft()
                if (a,b) == (nextX,nextY):
                    step += dist
                    x,y = nextX,nextY
                    break
                for i,j in [(0,1),(1,0),(-1,0),(0,-1)]:
                    if not (0<=a+i<m and 0<=b+j<n):
                        continue
                    if (a+i,b+j) in visited:
                        continue
                    if forest[a+i][b+j] == 0:
                        continue
                    visited.add((a+i,b+j))
                    queue.append((a+i,b+j,dist+1))
            if (x,y) != (nextX,nextY):
                return -1
        
        return step