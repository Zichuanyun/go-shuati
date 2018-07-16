public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = B[0].length, k = B.length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < k; ++j) {
                if(A[i][j] == 0) continue;
                for(int l = 0; l < n; ++l)
                    res[i][l] += A[i][j] * B[j][l];
            }
        }
        return res;
    }
}
