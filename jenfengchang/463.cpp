class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        if(grid.size()==0 || grid[0].size()==0) {
            return 0;
        }
        int res = 0;
        const int n = grid.size();
        const int m = grid[0].size();
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(grid[i][j]==1) {
                    int tmp = 0;
                    if(i>0 && grid[i-1][j]) {
                        tmp++;
                    }
                    if(j>0 && grid[i][j-1]) {
                        tmp++;
                    }
                    if((i+1)!=n && grid[i+1][j]) {
                        tmp++;
                    }
                    if((j+1)!=m && grid[i][j+1]) {
                        tmp++;
                    }
                    res += (4-tmp);
                }
            }
        }
        return res;
    }
};
