class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        if(grid.empty() || grid[0].empty()) return 0;
        int m = grid.size(), n = grid[0].size();
        int cnt = 0, edgeCnt = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j]) {
                    cnt++;
                    if(i && grid[i-1][j]) edgeCnt++;
                    if(j && grid[i][j-1]) edgeCnt++;
                }
            }
        }
        return cnt * 4 - edgeCnt * 2;
    }
};
