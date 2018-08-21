class Solution {
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        if(board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{click[0], click[1]});
        while(!q.isEmpty()) {
            int[] top = q.poll();
            if(board[top[0]][top[1]] != 'E') continue;
            int count = 0;
            List<int[]> next = new LinkedList<>();
            for(int[] dir : dirs) {
                int r = top[0] + dir[0], c = top[1] + dir[1];
                if(r < 0 || r >= m || c < 0 || c >= n) continue;
                if(board[r][c] == 'M') ++count;
                else if(board[r][c] == 'E') {
                    next.add(new int[]{r, c});
                }
            }
            if(count == 0) {
                board[top[0]][top[1]] = 'B';
                q.addAll(next);
            }
            else {
                board[top[0]][top[1]] = (char)('0' + count);
            }
        }
        return board;
    }
}
