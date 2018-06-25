class Solution(object):
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: int
        """
        res = [0]
        
        def dfs(layer, queens):
            if layer == n:
                res[0] += 1
                    
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
        return res[0]
                