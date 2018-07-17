class Solution:
    """
    @param A: a sparse matrix
    @param B: a sparse matrix
    @return: the result of A * B
    """
    def multiply(self, A, B):
      m,d,n = len(A),len(A[0]),len(B[0])
      res = [[0]*n for _ in range(m)]
      for i in range(m):
        for j in range(n):
          for k in range(d):
            if A[i][k] and B[k][j]:
              res[i][j] += A[i][k]*B[k][j]
      return res
      