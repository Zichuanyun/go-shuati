class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //use bfs to solve
        boolean[][] visited = new boolean[maze.length][maze[0].length]; 
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int xcor = start[0], ycor = start[1];
        Queue<int[]> temp = new LinkedList<>();  // use queue to keep track of the current position
        temp.add(start); 
        visited[xcor][ycor] = true;
        while(!temp.isEmpty()) {
            int[] current = temp.poll();
            if (current[0] == destination[0] && current[1] == destination[1]) {
                return true;
            }
            for(int dir = 0; dir < 4; dir++) {
                int x = current[0];
                int y = current[1];
                while(x >= 0 && x < maze.length  //while the ball hasn't hit the wall
                      && y >= 0 && y < maze[0].length
                     && maze[x][y] == 0) {
                    x += dx[dir];
                    y += dy[dir];
                }
                x -= dx[dir]; y -= dy[dir];  //roll back to previous state
                
                if(visited[x][y] == false) {
                    visited[x][y] = true;  //mark visited as true
                    temp.add(new int[]{x,y});  //add the coordinate to the queue
                }
            }
        }
        return false;
    }
}