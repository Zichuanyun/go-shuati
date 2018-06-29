class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0) return -1;
        int m = maze.length, n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] row: distance)
            Arrays.fill(row, -1);
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);
        return distance[destination[0]][destination[1]];
    }
    
    private void dfs(int[][] maze, int[] start, int[][] distance) {
        for(int[] dir : dirs) {
            int step = 0;
            int r = start[0] + dir[0], c = start[1] + dir[1];
            while(r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] == 0) {
                ++step;
                r += dir[0];
                c += dir[1];
            }
            r -= dir[0]; c -= dir[1];
            if(distance[start[0]][start[1]] + step < distance[r][c] || distance[r][c] == -1) {
                distance[r][c] = distance[start[0]][start[1]] + step;
                dfs(maze, new int[]{r, c}, distance);
            }
        }
    }
}
