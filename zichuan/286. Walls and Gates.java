class Solution {
    public void wallsAndGates(int[][] rooms) {
        // 不用再做一次比较哪个最近，因为一开始就是把 全部的 门给放到queue里面去了
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rooms.length; ++i) {
            for (int j = 0; j < rooms[0].length; ++j) {
                if (rooms[i][j] == 0) {
                    queue.offerLast(new int[] {i, j});
                }
            }
        }
        
        while (queue.size() > 0) {
            int[] curPos = queue.pollFirst();
            int x = curPos[0];
            int y = curPos[1];
            int level = rooms[x][y];
            for (int[] dir : DIRS) {
                int x_ = x + dir[0];
                int y_ = y + dir[1];
                if (x_ >= 0 && x_ < rooms.length && y_ >= 0 && y_ < rooms[0].length
                    && rooms[x_][y_] == Integer.MAX_VALUE) {
                    rooms[x_][y_] = level + 1;
                    queue.offerLast(new int[] {x_, y_});
                } 
            }
            
        }
    }
    
    private int[][] DIRS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
}