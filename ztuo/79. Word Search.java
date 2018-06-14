class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j++) {
                if (exist(board, words, i, j, 0) == true) {
                    return true; 
                }
            }
        }
        return false;
    }
    private boolean exist(char[][] board, char[] word, int x, int y, int index) {
        if(index == word.length) {
            return true;
        }
        if(x <0 ||y < 0 || x >= board.length || y >= board[0].length) return false;
        if (board[x][y] != word[index]) return false;
        
        board[x][y] ^= 256; // mark the cell as visited
            boolean exist = exist(board, word, x, y+1, index + 1)
		|| exist(board, word, x, y-1, index + 1)
		|| exist(board, word, x+1, y,  index + 1)
		|| exist(board, word, x-1, y,  index + 1);
        board[x][y] ^= 256; // unmark the cell
        
        return exist;        
    }
}