class Solution(object):
    def wordBreak(self, s, wordDict):
      """
      :type s: str
      :type wordDict: List[str]
      :rtype: List[str]
      """
      words = set(wordDict)
      dp = {}

      def breaker(s):
        if s in dp:
          return dp[s]
        
        res = []
        if s in words:
          res.append(s)
        for i in range(len(s)-1):
          _s = s[:i+1]
          if _s not in words:
            continue
          _res = breaker(s[i+1:])
          for tmp in _res:
            res.append(_s+' '+tmp)
        dp[s] = res
        return res

      return breaker(s)