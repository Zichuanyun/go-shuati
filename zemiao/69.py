class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        i = 0
        while i**2 < x:
          i += 1
        return i-1 if i**2 > x else i