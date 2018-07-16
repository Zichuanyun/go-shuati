class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        res = ""
        while n:
          res = res + chr((n-1)%26+ord('A'))
          n = (n-1)/26
        return res[::-1]