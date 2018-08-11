from collections import deque

class Solution(object):  
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        coins.sort(reverse=True)
        Q = deque([(0,0)])
        visited = set()
        while Q:
          s,count = Q.popleft()
          if s == amount:
            return count
          if s in visited or s > amount:
            continue
          
          visited.add(s)
          for c in coins:
            Q.append((s+c,count+1))
        return -1