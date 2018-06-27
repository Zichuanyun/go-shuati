class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int X = forest.size();
        int Y = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < X; ++i) {
            for (int j = 0; j < Y; ++j) {
                if (forest.get(i).get(j) != 0) {
                    trees.add(new int[] {forest.get(i).get(j), i, j});
                }
            }
        }
        trees.sort((a, b) -> a[0] - b[0]);
        int count = 0;
        for (int i = 0; i < trees.size(); ++i) {
            List<int[]> cur_level = new ArrayList<>();
            boolean[][] visited = new boolean[X][Y];
            if (i == 0) {
                cur_level.add(new int[] {0, 0});
                visited[0][0] = true;
            } else {
                cur_level.add(new int[] {trees.get(i - 1)[1], trees.get(i - 1)[2]});
                visited[trees.get(i - 1)[1]][trees.get(i - 1)[2]] = true;
            }
            int res = bfs(cur_level, forest, trees.get(i)[1], trees.get(i)[2], X, Y, visited);
            if (res == -1) return -1;
            count += res;
        }
        return count;
    }

    private int bfs(List<int[]> cur_level, List<List<Integer>> forest, int t_x, int t_y, int X, int Y, boolean[][] visited) {
        List<int[]> next_level = new ArrayList<>();
        for (int[] pos : cur_level) {
            if (pos[0] == t_x && pos[1] == t_y) return 0;
            visited[pos[0]][pos[1]] = true;
            for (int[] dir : DIRS) {
                int[] next_step = new int[] {pos[0] + dir[0], pos[1] + dir[1]};
                if (next_step[0] >= 0 && next_step[0] < X && next_step[1] >= 0 && next_step[1] < Y
                   && forest.get(next_step[0]).get(next_step[1]) != 0 && visited[next_step[0]][next_step[1]] == false) {
                    next_level.add(next_step);
                }
            }
        }
        if (next_level.size() == 0) return -1;
        int res = bfs(next_level, forest, t_x, t_y, X, Y, visited);
        if (res == -1) return -1;
        else return res + 1;
    }
    private int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
}