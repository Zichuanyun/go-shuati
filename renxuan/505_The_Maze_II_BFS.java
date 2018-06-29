class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0) return -1;
        int m = maze.length, n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] row: distance)
            Arrays.fill(row, -1);
        distance[start[0]][start[1]] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1]});
        while(!q.isEmpty()) {
            int[] top = q.poll();
            for(int[] dir : dirs) {
                int step = 0;
                int r = top[0] + dir[0], c = top[1] + dir[1];
                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0) {
                    ++step;
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0]; c -= dir[1];
                if(distance[top[0]][top[1]] + step < distance[r][c] || distance[r][c] == -1) {
                    distance[r][c] = distance[top[0]][top[1]] + step;
                    q.offer(new int[]{r, c, distance[r][c]});
                }
            }
        }
        return distance[destination[0]][destination[1]];
    }
}
