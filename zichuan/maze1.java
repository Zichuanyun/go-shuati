class Solution {
    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] des) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, des, visited);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] des, boolean visited[][]) {
        if (visited[start[0]][start[1]]) {
            return false;
        }
        
        if (start[0] == des[0] && start[1] == des[1]) {
            return true;
        }
        visited[start[0]][start[1]] = true;
        for (int i = 0; i < 4; ++i) {
            int x = start[0], y = start[1];
            while (true) {
                x += dir[i][0];
                y += dir[i][1];
                if (x >= maze.length || x < 0
                   || y >= maze[0].length || y < 0 || maze[x][y] == 1) {
                    break;
                }
            }
            x -= dir[i][0];
            y -= dir[i][1];
            if (dfs(maze, new int[] {x, y}, des, visited)) {
                return true;
            }
        }
        return false;
    }
}