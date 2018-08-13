class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        n = len(s)
        
        def palin(centerL,centerR):
          while centerL>=0 and centerR<n:
            if s[centerL] != s[centerR]:
              break
            centerL -= 1
            centerR += 1
          return s[centerL+1:centerR]
         
        res = ""
        for i in range(n):
          tmp = palin(i,i)
          if len(tmp)>len(res):
            res = tmp
            
        for i in range(n-1):
          tmp = palin(i,i+1)
          if len(tmp)>len(res):
            res = tmp
          
        return res