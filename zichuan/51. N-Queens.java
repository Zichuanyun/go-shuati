class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] visited = new int[n];
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            visited[i] = -1;
        }
        for (int i = 0; i < n; ++i) {
            visited[0] = i;
            dfs(visited, 1, res);
        }
        return res;
    }
    
    private void dfs(int[] visited, int x, List<List<String>> res) {
        int n = visited.length;
        if (n == x) {
            List<String> str = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                StringBuilder sb = new StringBuilder("");
                for (int j = 0; j < n; ++j) {
                    if (visited[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                str.add(sb.toString());
            }
            res.add(str);
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
                dfs(visited, x + 1, res);
            }
        }
    }
}