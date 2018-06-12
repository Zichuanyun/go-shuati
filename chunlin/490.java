class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[] toX = new int[] {0, 0, -1, 1};
        int[] toY = new int[] {-1, 1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] hash = new boolean[m][n];
        queue.offer(start);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int next_x = cur[0];
                int next_y = cur[1];
                while (next_x >= 0 && next_x < m && next_y >= 0 && next_y < n
                      && maze[next_x][next_y] == 0) {
                    next_x = next_x + toX[i];
                    next_y = next_y + toY[i];
                }
                next_x = next_x - toX[i];
                next_y = next_y - toY[i];
                if (hash[next_x][next_y]) {
                    continue;
                }
                hash[next_x][next_y] = true;
                if (next_x == destination[0] && next_y == destination[1]) {
                    return true;
                }
                queue.offer(new int[]{next_x, next_y});
            }
        }
        return false;
    }
}
