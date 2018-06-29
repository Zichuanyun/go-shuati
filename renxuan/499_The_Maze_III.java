class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    char[] dirsC = {'d', 'u', 'r', 'l'};
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;
        String[][] route = new String[m][n];
        
        route[ball[0]][ball[1]] = "";
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ball[0], ball[1]});
        while(!q.isEmpty()) {
            int[] top = q.poll();
            for(int i = 0; i < dirs.length; ++i) {
                int[] dir = dirs[i];
                char dirC = dirsC[i];
                String step = "";
                int r = top[0] + dir[0], c = top[1] + dir[1];
                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0 && (r != hole[0] || c != hole[1])) {
                    step += dirC;
                    r += dir[0];
                    c += dir[1];
                }
                if(r != hole[0] || c != hole[1]) {
                    r -= dir[0]; c -= dir[1];
                }
                else step += dirC;
                if(route[r][c] == null || (route[top[0]][top[1]] + step).length() < route[r][c].length() || (route[top[0]][top[1]] + step).length() == route[r][c].length() && (route[top[0]][top[1]] + step).compareTo(route[r][c]) < 0) {
                    route[r][c] = route[top[0]][top[1]] + step;
                    if(r != hole[0] || c != hole[1])
                        q.offer(new int[]{r, c});
                }
            }
        }
        if(route[hole[0]][hole[1]] == null) return "impossible";
        return deleteContinuousRepeat(route[hole[0]][hole[1]]);
    }
    
    private String deleteContinuousRepeat(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ca = s.toCharArray();
        for(int i = 0; i < ca.length; ++i) {
            if(i == 0 || ca[i] != ca[i - 1])
                sb.append(ca[i]);
        }
        return sb.toString();
    }
}
