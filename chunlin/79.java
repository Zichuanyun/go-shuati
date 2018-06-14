class Solution {
    private int m;
    private int n;
    private boolean[][] isVisit;
    private int[] toX = {0, 0, -1, 1};
    private int[] toY = {-1, 1, 0, 0};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        isVisit = new boolean[m][n];
        boolean result = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && helper(board, word, 0, i, j)) {       
                    return true;      // lack && board[i][j] == word.charAt(0), TLE
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int start, int i, int j) {      // change concat str to startIndex
        if (start == word.length()) {
            return true;
        }
        if (!isValid(i, j) || word.charAt(start) != board[i][j]) {          // return false earlier
            return false;
        }
        boolean res = false;
        isVisit[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nextX = i + toX[k];        // forgot []
            int nextY = j + toY[k];
            res = res || helper(board, word, start + 1, nextX, nextY);
        }
        isVisit[i][j] = false;
        
        return res;
    }
    private boolean isValid(int i, int j) {
        return (i >= 0 && i < m && j >= 0 && j < n && !isVisit[i][j]);
    }
}
