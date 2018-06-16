class Solution {
    public boolean exist(char[][] board, String word) {
        // corner case
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        if (word.length() == 0) {
            return true;
        }
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, new boolean[board.length][board[0].length], 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, boolean[][] visited, int idx, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        
        if (visited[x][y] || idx >= word.length() || board[x][y] != word.charAt(idx)) {
            return false;
        }
        
        if (idx == word.length() - 1) {
            return true;
        }
        visited[x][y] = true;
        idx++;
        
        for (int i = 0; i < 4; ++i) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (dfs(board, word, visited, idx, newX, newY)) {
                return true;
            }
        }
        visited[x][y] = false;
        
        return false;
    }
    
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
}