class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        tried = {}
        
        def dfs(s):
            if s == "":
                return True
            if s in tried:
                return False
            
            n = len(s)
            for w in wordDict:
                if len(w) <= n and w == s[:len(w)] and dfs(s[len(w):]):
                    return True
                
            tried[s] = True
            return False
        
        return dfs(s)