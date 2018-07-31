class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        unordered_map<int, int> cnt;
        int maxGaps = 0;
        for(auto &row: wall) {
            for(int i = 0, sum = 0; i < row.size() - 1; i++) {
                sum += row[i];
                cnt[sum]++;
                maxGaps = max(maxGaps, cnt[sum]);
            }
        }
        return wall.size() - maxGaps;
    }
};
