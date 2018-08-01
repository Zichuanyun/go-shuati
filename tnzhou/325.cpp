class Solution {
public:
    int maxSubArrayLen(vector<int>& nums, int k) {
        unordered_map<int, int> posMap;
        int cur_total = 0;
        vector<int> accSum;
        accSum.push_back(0);
        posMap[0] = 1;
        for (int i = 0; i < nums.size(); i++) {
            cur_total += nums[i];
            accSum.push_back(cur_total);
            if (posMap[cur_total] == 0) {
                posMap[cur_total] = i + 2;
            }
        }
        int res = 0;
        for (int i = 0; i < accSum.size(); i++) {
            int wantNum = accSum[i] - k;
            if (posMap[wantNum] != 0 && posMap[wantNum] < i + 2) {
                res = max(res, i + 1 - posMap[wantNum]);
            }
        }
        return res;
    }
};
