class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m, n;
    
    public int cutOffTree(List<List<Integer>> forest) {
        m = forest.size();
        n = forest.get(0).size();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(forest.get(i).get(j) > 1)
                    pq.offer(new int[]{i, j, forest.get(i).get(j)});
            }
        }
        int res = 0;
        int[] start = {0, 0};
        while(!pq.isEmpty()) {
            int[] next = pq.poll();
            int step = bfs(forest, start, next);
            if(step == -1) return -1;
            res += step;
            start = next;
        }
        return res;
    }
    
    private int bfs(List<List<Integer>> forest, int[] start, int[] end) {
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; ++i) {
                int[] curr = q.poll();
                if(curr[0] == end[0] && curr[1] == end[1]) return step;
                for(int[] dir : dirs) {
                    int r = curr[0] + dir[0], c = curr[1] + dir[1];
                    if(r < 0 || r >= m || c < 0 || c >= n || forest.get(r).get(c) == 0 || visited[r][c])
                        continue;
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
            ++step;
        }
        return -1;
    }
}
