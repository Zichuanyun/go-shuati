class Solution {
    
    int m, n;
    public List<Integer> spiralOrder(int[][] matrix) {
        //corner case
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        m = matrix.length;
        n = matrix[0].length;
        
        helper(matrix, res, 0);
        
        return res;
    }
    
    public void helper(int[][] matrix, List<Integer> res, int x) {
        if(x > (m - 1) / 2 || x > (n - 1) / 2) return;
        
        for(int i = x; i < n - x; i++) {
            res.add(matrix[x][i]);
        }
        
        for(int i = x + 1; i < m - x; i++) {
            res.add(matrix[i][n - x - 1]);
        }
        
        if(m - x - 1 > x && n - x - 1 > x) {
            for(int i = n - x - 2; i > x; i--) {
                res.add(matrix[m - x - 1][i]);
            }

            for(int i = m - x - 1; i > x; i--) {
                res.add(matrix[i][x]);
            }
        }
        helper(matrix, res, ++x);
    }
}
