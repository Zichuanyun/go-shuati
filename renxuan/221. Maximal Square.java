class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, maxEdge = 0;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    maxEdge = Math.max(maxEdge, dp[i][j]);
                }
            }
        }
        return maxEdge * maxEdge;
    }
}
