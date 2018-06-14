class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return false;
        for(int i = 0; i < board.length; ++i)
            for(int j = 0; j < board[0].length; ++j)
                if(dfs(board, word, 0, i, j))
                    return true;
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int index, int row, int col) {        
        if(index == word.length())
            return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;
        if(board[row][col] == word.charAt(index)) {
            board[row][col] ^= 128;
            if (dfs(board, word, index + 1, row + 1, col)
             || dfs(board, word, index + 1, row - 1, col)
             || dfs(board, word, index + 1, row, col + 1)
             || dfs(board, word, index + 1, row, col - 1))
                return true;
            board[row][col] ^= 128;
        }
        return false;
    }
}