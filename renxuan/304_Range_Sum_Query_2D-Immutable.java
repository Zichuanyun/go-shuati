class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 1; i <= matrix.length; ++i) {
            for(int j = 1; j <= matrix[0].length; ++j) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] + matrix[i - 1][j - 1] - sum[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(sum == null) return 0;
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
 