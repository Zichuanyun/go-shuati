class NumMatrix {
    int[][] BIT, nums;
    int m, n;

    public NumMatrix(int[][] matrix) {
        m = matrix.length; n = matrix[0].length;
        BIT = new int[m + 1][n + 1];
        nums = new int[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j)
                update(i, j, matrix[i][j]);
        }
    }
    
    public void update(int row, int col, int val) {
        int diff = val - nums[row][col];
        nums[row][col] = val;
        for(int i = row + 1; i <= m; i += lowBit(i)) {
            for(int j = col + 1; j <= n; j += lowBit(j)) {
                BIT[i][j] += diff;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum(row2, col2) - prefixSum(row2, col1 - 1) - prefixSum(row1 - 1, col2) + prefixSum(row1 - 1, col1 - 1);
    }
    
    private int prefixSum(int row, int col) {
        int sum = 0;
        for(int i = row + 1; i > 0; i -= lowBit(i)) {
            for(int j = col + 1; j > 0; j -= lowBit(j)) {
                sum += BIT[i][j];
            }
        }
        return sum;
    }
    
    private int lowBit(int i) {
        return i & (-i);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
 