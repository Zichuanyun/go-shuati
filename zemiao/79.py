class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if len(board)==0:
            return False
        
        m,n = len(board), len(board[0])
        seen = [[False]*n for _ in range(m)]
        
        def dfs(a,b,i):
            if seen[a][b] or board[a][b]!=word[i]:
                return False
            
            if i == len(word)-1:
                return True
            
            seen[a][b] = True
            if b+1 < n and dfs(a,b+1,i+1):
                return True
            if b-1 >=0 and dfs(a,b-1,i+1):
                return True
            if a+1 < m and dfs(a+1,b,i+1):
                return True
            if a-1 >=0 and dfs(a-1,b,i+1):
                return True
            
            seen[a][b] = False
            return False
        
        for i in range(m):
            for j in range(n):
                if dfs(i,j,0):
                    return True
        return False