class Solution {
    public int totalNQueens(int n) {
        int[] visited = new int[n];
        for (int i = 0; i < n; ++i) {
            visited[i] = -1;
        }
        int[] count = new int[] {0};
        for (int i = 0; i < n; ++i) {
            visited[0] = i;
            dfs(visited, 1, count);
        }
        
        return count[0];
    }
    
    private void dfs(int[] visited, int x, int[] count) {
        int n = visited.length;
        if (n == x) {
            ++count[0];
            return;
        }
        
        for (int y = 0; y < n; ++y) {
            boolean flag = true;
            for (int i = 0; i < x; ++i) {
                int j = visited[i];
                if (x == i || y == j || x - i == y - j || x - i == j - y) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                visited[x] = y;
                dfs(visited, x + 1, count);
            }
        }
    }
}