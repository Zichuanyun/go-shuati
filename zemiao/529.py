class Solution(object):
    def updateBoard(self, board, click):
        """
        :type board: List[List[str]]
        :type click: List[int]
        :rtype: List[List[str]]
        """
        m,n = len(board),len(board[0])
        a,b = click[0],click[1]
        if board[a][b] == 'M':
          board[a][b] = 'X'
          return board
        
        stack = [(a,b)]
        while stack:
          a,b = stack.pop()
          if board[a][b] != 'E':
            continue
            
          mines = 0
          empty = []
          for x in [1,0,-1]:
            for y in [1,0,-1]:
              if 0<=a+x<m and 0<=b+y<n:
                if board[a+x][b+y]=='M':
                  mines += 1
                if board[a+x][b+y]=='E':
                  empty.append((a+x,b+y))
              
          if mines:
            board[a][b] = str(mines)
            continue
          
          board[a][b] = 'B'
          for e in empty:
            stack.append(e)
            
        return board