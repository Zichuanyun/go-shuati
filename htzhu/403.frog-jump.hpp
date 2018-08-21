class Solution {
public:
    bool canCross(vector<int>& stones) {
        int n = stones.size();
        unordered_map<int, unordered_set<int>> dp;
        for(int x: stones) dp[x];
        dp[0].insert(0);
        for(int i = 0; i < n - 1; i++) {
            int pos = stones[i];
            for(int k: dp[pos])
                for(int step = k - 1; step <= k + 1; step++)
                    if(step > 0 && dp.count(pos + step))
                        dp[pos + step].insert(step);
        }
        return dp[stones.back()].size() > 0;
    }
};
