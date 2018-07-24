class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> cur_result;
        if (nums.size() == 0) 
            return result;
        vector<int> temp {};
        result.push_back(temp);
        fetchAllResults(nums, cur_result, result, 0);
        return result;
    }

    void fetchAllResults(vector<int>& nums, vector<int>& cur_res, vector<vector<int>>& final_res, int this_idx) {
        if (this_idx >= nums.size()) {
            return;
        }
        cur_res.push_back(nums[this_idx]);
        final_res.push_back(cur_res);
        fetchAllResults(nums, cur_res, final_res, this_idx + 1);
        cur_res.pop_back();
        fetchAllResults(nums, cur_res, final_res, this_idx + 1);
    }

};
