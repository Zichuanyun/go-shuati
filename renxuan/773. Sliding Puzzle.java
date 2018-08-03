class Solution {
    final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int slidingPuzzle(int[][] board) {
        int serial = serialize(board);
        if(serial == 123450) return 0;
        Set<Integer> set = new HashSet<>();
        Queue<int[][]> q = new LinkedList<>();
        q.offer(board);
        set.add(serial);
        int move = 0;
        while(!q.isEmpty()) {
            ++move;
            int size = q.size();
            for(int i = 0; i < size; ++i) {
                int[][] top = q.poll();
                int[] zero = findZero(top);
                for(int[] dir : dirs) {
                    int row = zero[0] + dir[0], col = zero[1] + dir[1];
                    if(row >= 0 && row <= 1 && col >= 0 && col <= 2) {
                        int[][] clone = new int[2][3];
                        clone2d(clone, top);
                        swap(clone, row, col, zero[0], zero[1]);
                        serial = serialize(clone);
                        if(serial == 123450) return move;
                        if(!set.contains(serial)) {
                            q.offer(clone);
                            set.add(serial);
                        }
                    }
                }
            }
        }
        return -1;        
    }
    
    private void clone2d(int[][] clone, int[][] original) {
        for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < 3; ++j) {
                clone[i][j] = original[i][j];
            }
        }
    }
    
    private int serialize(int[][] board) {
        return board[0][0] * 100000 + board[0][1] * 10000 + board[0][2] * 1000 
            + board[1][0] * 100 + board[1][1] * 10 + board[1][2] * 1;
    }
    
    private int[] findZero(int[][] board) {
        for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < 3; ++j) {
                if(board[i][j] == 0)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
    
    private void swap(int[][] board, int row1, int col1, int row2, int col2) {
        int tmp = board[row1][col1];
        board[row1][col1] = board[row2][col2];
        board[row2][col2] = tmp;
    }
}
