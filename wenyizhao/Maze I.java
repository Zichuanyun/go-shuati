class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //dfs
        if(maze==null || maze.length ==0 || maze[0].length==0)
            return false;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return hasPath(maze, visited, start, destination);
    }
    private boolean hasPath(int[][] maze, boolean[][] visited, int[] start, int[] des){
        if(visited[start[0]][start[1]]) return false;
        if(start[0]==des[0]&&start[1]==des[1]) return true;
        visited[start[0]][start[1]] = true;
        //four direction
        int[] xDir = new int[]{0,0,-1,1};
        int[] yDir = new int[]{1,-1,0,0};
        for(int i = 0; i < 4; i++){
            int[] newStart = new int[2];
            int x = start[1];
            int y = start[0];
            while(y < maze.length && y >= 0 && x < maze[0].length && x >= 0 && maze[y][x]==0){
                y += yDir[i];
                x += xDir[i];
            }
            x -= xDir[i]; y -= yDir[i];
            if(hasPath(maze, visited, new int[]{y, x},des)) return true;
        }
        return false;
    }
}
