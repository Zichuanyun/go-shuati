class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        res = []
        
        def dfs(layer, queens):
            if layer == n:
                ans =[]
                for i in range(n):
                    ans.append('.'*queens[i]+'Q'+'.'*(n-1-queens[i]))
                res.append(ans)
                    
            for i in range(n):
                if i in queens:
                    continue
                found = True
                for j in range(layer):
                    if i-layer+j==queens[j] or i+layer-j==queens[j]:
                        found = False
                        break
                if found:
                    queens[layer] = i
                    dfs(layer+1, queens)
                    queens[layer] = -1
            
        dfs(0,[-1]*n)
        return res
                