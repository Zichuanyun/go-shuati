# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        l, r = 1, n
        while l<r:
          mid = l+(r-l)/2
          if isBadVersion(mid):
            r = mid
          else:
            if l+1==r:
              return r if isBadVersion(r) else -1
            l = mid
        return l