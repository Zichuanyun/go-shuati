class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        n = len(citations)
        if n == 0:
          return 0
        
        l, r = 1, n
        while l < r:
          mid = l + (r-l)/2
          if citations[n-mid] >= mid:
            if mid == l:
              if citations[n-r] >= r:
                l = r
              break
            l = mid
          else:
            r = mid
            
        # l is the largest index s.t. c[n-l] >= l
        return l if citations[n-l]>0 else 0