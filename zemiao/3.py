class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
          return 0
        
        n = len(s)
        begin = 0
        res = 0
        map = {}
        for i in range(n):
          if s[i] in map:
            begin = max(map[s[i]]+1,begin)
          map[s[i]] = i

          res = max(res,i-begin+1)
          
        return res