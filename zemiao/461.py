class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        z = x^y
        res = 0
        while z:
          res += z&1
          z = z >> 1
        return res