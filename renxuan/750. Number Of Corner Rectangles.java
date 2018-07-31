public class Solution {
    public int countCornerRectangles(int[][] grid) {
        if(grid.length <= 1 || grid[0].length <= 1) return 0;
        int m = grid.length, n = grid[0].length, res = 0;
        for(int i = 0; i < m; ++i) {
            for(int j = i + 1; j < m; ++j) {
                int count = 0;
                for(int c = 0; c < n; ++c) {
                    if(grid[i][c] == 1 && grid[j][c] == 1)
                        ++count;
                }
                res += count * (count - 1) / 2;
            }
        }
        return res;
    }
}
