class Solution {
    int res = 0;
    
    public int totalNQueens(int n) {
        int[] queens = new int[n];
        dfs(queens, 0, n);
        return res;
    }
    
    private void dfs(int[] queens, int row, int n) {
        if(row == n) {
            ++res;
            return;
        }
        for(int col = 0; col < n; ++col) {
            if(valid(queens, row, col, n)) {
                queens[row] = col;
                dfs(queens, row + 1, n);
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
