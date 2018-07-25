class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0 || A[0].length == 0 || B[0].length == 0 || A[0].length != B.length) return null;
        int i = A.length;
        int j = A[0].length;
        int k = B[0].length;
        int[][] C = new int[i][k];
        for(int m = 0; m < i; m++) {
            for(int n = 0; n < j; n++) {
                if(A[m][n] != 0) {
                    for(int l = 0; l < k; l++) {
                        C[m][l] += A[m][n] * B[n][l];
                    }
                }
            }
        }
        return C;
    }
}