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
        left = 1
        right = n
        while left < right:
            m = (left + right) / 2
            if isBadVersion(m):
                right = m
            else:
                left = m + 1
        return left
        
"""
Don't know why same alogorithm on C++ is TLE.
"""
