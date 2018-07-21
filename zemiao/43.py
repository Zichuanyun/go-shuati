class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        def times(num,c):
          cv,c0 = ord(c),ord('0')
          res = 0
          for i in num:
            res = res*10 + (ord(i)-c0)*(cv-c0)
          return res
        
        v = 1
        res = 0
        for c in reversed(num2):
          res += v*times(num1, c)
          v *= 10
        return str(res)