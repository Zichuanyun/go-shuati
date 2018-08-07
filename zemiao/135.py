class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        rises = []
        n = len(ratings)
        for i in range(1,n):
          if ratings[i]>ratings[i-1]:
            rises.append(1)
          elif ratings[i]==ratings[i-1]:
            rises.append(0)
          else:
            rises.append(-1)
        
        ltor, rtol = [1],[1]
        for i in range(0,n-1):
          if rises[i]==1:
            ltor.append(ltor[-1]+1)
          else:
            ltor.append(1)
            
        for i in reversed(range(0,n-1)):
          if rises[i]==-1:
            rtol.append(rtol[-1]+1)
          else:
            rtol.append(1)  
        rtol.reverse()
        
        res = 0
        for i in range(n):
          res += max(ltor[i],rtol[i])
        return res