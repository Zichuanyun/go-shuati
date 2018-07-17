class Solution {
public:
    int minCostII(vector<vector<int>>& costs) {
        if(costs.empty() || costs[0].empty()) return 0;
        int n = costs.size(), k = costs[0].size();
        int min1 = 0, min2 = 0, minColor = -1;
        for(int i = 0; i < n; i++) {
            int m1 = INT_MAX, m2 = INT_MAX, c = 0;
            for(int j = 0; j < k; j++) {
                int cost = costs[i][j] + (j != minColor ? min1 : min2);
                if(cost < m1) {
                    m2 = m1;
                    m1 = cost;
                    c = j;
                } else if(cost < m2) {
                    m2 = cost;
                }
            }
            min1 = m1;
            min2 = m2;
            minColor = c;
        }
        return min1;
    }
};
