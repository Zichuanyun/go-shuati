class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        dfs(res, queens, 0, n);
        return res;
    }
    
    private void dfs(List<List<String>> res, int[] queens, int row, int n) {
        if(row == n) {
            List<String> tmp = new ArrayList<>();
            for(int i = 0; i < n; ++i) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; ++j) {
                    if(j == queens[i]) sb.append('Q');
                    else sb.append('.');
                }
                tmp.add(sb.toString());
            }
            res.add(tmp);
            return;
        }
        for(int col = 0; col < n; ++col) {
            if(valid(queens, row, col, n)) {
                queens[row] = col;
                dfs(res, queens, row + 1, n);
            }
        }
    }
    
    private boolean valid(int[] queens, int row, int col, int n) {
        for(int i = 0; i < row; ++i) {
            if(queens[i] == col || row - i == col - queens[i] || row - i == queens[i] - col)
                return false;
        }
        return true;
    }
}
