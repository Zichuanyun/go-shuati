class Solution {
    public int swimInWater(int[][] grid) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        visited[0][0] = true;
        q.offer(new int[]{0, 0, grid[0][0]});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] == n-1 && curr[1] == n-1) return curr[2];
            for(int[] dir : dirs) {
                int r = curr[0] + dir[0], c = curr[1] + dir[1];
                if(r < 0 || r >= n || c < 0 || c >= n || visited[r][c])
                    continue;
                q.offer(new int[]{r, c, Math.max(curr[2], grid[r][c])});
                visited[r][c] = true;
            }
        }
        return -1;
    }
}
