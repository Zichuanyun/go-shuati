class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if(m == 0) return res;
        int n = matrix[0].length;
        int u = 0, d = m - 1, l = 0, r = n - 1, count = 0;
        while(count < m * n){
            for(int i = l; i <= r; ++i) {
                res.add(matrix[u][i]);
                ++count;
            }
            for(int i = u + 1; i <= d; ++i) {
                res.add(matrix[i][r]);
                count++;
            }
            if(count >= m * n) break;
            for(int i = r - 1; i >= l; --i) {
                res.add(matrix[d][i]);
                count++;
            }
            for(int i = d - 1;i > u; --i) {
                res.add(matrix[i][l]);
                count++;
            }
            ++u; ++l; --r; --d;
        }
        return res;
    }
}
