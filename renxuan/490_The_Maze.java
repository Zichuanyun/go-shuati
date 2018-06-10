public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0) return false;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        q.offer(start);
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            for(int[] dir : dirs) {
                int r = curr[0];
                int c = curr[1];
                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0) {
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                if(!visited[r][c]) {
                    visited[r][c] = true;
                    q.offer(new int[] {r, c});
                }
            }
        }
        return false;
    }
}