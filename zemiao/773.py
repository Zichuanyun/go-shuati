from collections import deque
from copy import deepcopy

class Solution(object):
    def slidingPuzzle(self, board):
        """
        :type board: List[List[int]]
        :rtype: int
        """
        visited = set([str(board)])
        i,j = 0,0
        for i in range(2):
          for j in range(3):
            if board[i][j]==0:
              a,b = i,j
        
        Q = deque()
        Q.append((a,b,0,board))
        final = str([[1,2,3],[4,5,0]])
        while Q:
          a,b,step,_board = Q.popleft()
          if str(_board)==final:
            return step
          
          for x,y in [(1,0),(0,1),(-1,0),(0,-1)]:
            if 0<=a+x<=1 and 0<=b+y<=2:
              _board[a+x][b+y],_board[a][b] = _board[a][b],_board[a+x][b+y]

              s = str(_board)
              if s not in visited:
                visited.add(s)
                Q.append((a+x,b+y,step+1,deepcopy(_board)))
                
              _board[a+x][b+y],_board[a][b] = _board[a][b],_board[a+x][b+y]
              
        return -1