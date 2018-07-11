class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        n = len(citations)
        
        # buckets[i] is the count of citations >= i
        buckets = [0]*(n+1)
        for i in citations:
          if 0 < i <= n:
            buckets[i] += 1
          elif i > n:
            buckets[n] += 1
        
        for i in reversed(range(1,n)):
          buckets[i] += buckets[i+1]
        
        res = 0
        for i in range(1,n+1):
          if i <= buckets[i]:
            res = i
        return res