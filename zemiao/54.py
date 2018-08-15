class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        if not matrix:
          return []
        m,n = len(matrix),len(matrix[0])
        
        def out(layer):
          res = []
          for i in range(n-layer*2):
            res.append(matrix[layer][layer+i])
            
          for i in range(m-layer*2-1):
            res.append(matrix[layer+1+i][n-1-layer])

          if layer != m-1-layer:
            for i in range(n-layer*2-1):
              res.append(matrix[m-1-layer][n-1-layer-i-1])

          if layer != n-1-layer:
            for i in range(m-layer*2-2):
              res.append(matrix[m-1-layer-i-1][layer])
              
          if 2*(layer+1)>=m or 2*(layer+1)>=n:
            return res
          return res+out(layer+1)
          
        return out(0)