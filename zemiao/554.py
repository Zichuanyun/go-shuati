from collections import defaultdict

class Solution(object):
    def leastBricks(self, wall):
        """
        :type wall: List[List[int]]
        :rtype: int
        """
        if not wall:
          return 0
        
        map = defaultdict(int)
        m = 0
        for b in wall[0]:
          m += b

        maxNoCrossCount = 0
        for w in wall:
          x = 0
          for brick in w:
            x += brick
            if x < m:
              map[x] += 1
              maxNoCrossCount = max(maxNoCrossCount, map[x])
        
        return len(wall)-maxNoCrossCount