class Solution {
public:
    int countCornerRectangles(vector<vector<int>>& grid) {
        if(grid.empty() || grid[0].empty()) return 0;
        int n = grid[0].size();
        unordered_map<int, int> cnt;
        int ans = 0;
        for(auto &row: grid) {
            for(int c1 = 0; c1 < n; c1++)
                if(row[c1])
                    for(int c2 = c1 + 1; c2 < n; c2++)
                        if(row[c2]) {
                            int pos = c1 * n + c2;
                            ans += cnt[pos];
                            cnt[pos]++;
                        }
        }
        return ans;
    }
};
