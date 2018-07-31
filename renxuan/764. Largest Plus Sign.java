class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] res = new int[N][N];
        for(int[] row : res){
            Arrays.fill(row, N);
        }
        for(int[] mine: mines){
            res[mine[0]][mine[1]] = 0;
        }
        for(int i = 0; i < N; ++i) {
            int l = 0, r = 0, u = 0, d = 0;
            for(int j = 0, k = N - 1; j < N; ++j, --k) {
                res[i][j] = Math.min(res[i][j], l = (res[i][j] == 0 ? 0 : l + 1));
                res[i][k] = Math.min(res[i][k], r = (res[i][k] == 0 ? 0 : r + 1));
                res[j][i] = Math.min(res[j][i], u = (res[j][i] == 0 ? 0 : u + 1));
                res[k][i] = Math.min(res[k][i], d = (res[k][i] == 0 ? 0 : d + 1));
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, res[i][j]);
            }
        }
        return max;
    }
}
