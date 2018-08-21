class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        res = []
        
        def dfs(tmp,left):
          if len(tmp)==n*2:
            res.append(tmp)
            return
          
          if left == n:
            dfs(tmp+')',left)
            return
          
          dfs(tmp+'(',left+1)
          
          right = len(tmp)-left
          if left>right:
            dfs(tmp+')',left)
          
        dfs("",0)
        return res