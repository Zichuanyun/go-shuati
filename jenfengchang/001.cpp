class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> value_idx;
        for (int idx = 1; idx <= nums.size(); idx++) {
            if(value_idx[target - nums[idx - 1]]) {
                return {value_idx[target - nums[idx - 1]] - 1, idx - 1};
            }
            value_idx[nums[idx -1]] = idx;
        }
        return {-1, -1};
    }
};
