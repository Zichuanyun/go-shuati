class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 ||matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] d = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    d[i][j] = Math.min(Math.min(d[i-1][j], d[i][j-1]), d[i-1][j-1]) + 1;
                    max = Math.max(max, d[i][j]);
                }
            }
        }
        return max * max;
    }
}