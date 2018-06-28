class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] des) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; ++i) {
            for (int j = 0; j < maze[0].length; ++j) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, des, distance);
        return distance[des[0]][des[1]] == Integer.MAX_VALUE ? -1 : distance[des[0]][des[1]];
    }
    private void dfs(int[][] maze, int[] start, int[] des, int[][] distance) {
        for (int[] dir : DIRS) {
            int len = 0;
            int x = start[0] + dir[0], y = start[1] + dir[1];
            while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
                ++len;
            }
            x -= dir[0];
            y -= dir[1];
            if (distance[start[0]][start[1]] + len < distance[x][y]) {
                distance[x][y] = distance[start[0]][start[1]] + len;
                dfs(maze, new int[] {x, y}, des, distance);
            }
        }
    }
    private int[][] DIRS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
}