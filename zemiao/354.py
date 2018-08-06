class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        # reverse hegihts for same width, s.t. what remains in [seq] is the tightest choice
        envelopes.sort(key=lambda x:(x[0],-x[1]))
        
        seq = []
        def binarySearch(x):
          l,r = 0,len(seq)-1
          while l<=r:
            mid = l+(r-l)/2
            if seq[mid][0]<x[0] and seq[mid][1]<x[1]:
              l = mid+1
            elif seq[mid] == x:
              return mid
            else:
              r = mid-1
          return l
        
        res = 0
        for x in envelopes:
          i = binarySearch(x)
          if i<len(seq):
            seq[i] = x
          else:
            seq.append(x)
            res += 1
        return res