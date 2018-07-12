class NumMatrix(object):

    def __init__(self, matrix):
        """
        :type matrix: List[List[int]]
        """
        if not matrix:
          return
        self.m, self.n = len(matrix), len(matrix[0])
        self.sums = [[0]*(1+self.n) for _ in range(1+self.m)]
        for i in range(self.m):
          tempSum = 0
          for j in range(self.n):
            tempSum += matrix[i][j]
            self.sums[i+1][j+1] = tempSum + self.sums[i][j+1]

    def sumRegion(self, row1, col1, row2, col2):
        """
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        if row1<0 or col1<0 or row2>=self.m or col2>=self.n:
          return 0
        return self.sums[row2+1][col2+1]-self.sums[row2+1][col1]-self.sums[row1][col2+1]+self.sums[row1][col1]


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)