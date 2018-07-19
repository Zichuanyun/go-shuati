class Solution {
public:
    unordered_map <string, bool> inserted;
    
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        inserted.clear();
        sort(nums.begin(), nums.end());
        vector<vector<int>> result;
        vector<int> cur_result;
        if (nums.size() == 0) 
            return result;
        fetchAllResults(nums, cur_result, result, 0);
        return result;
    }
    
    string convertToString(vector<int>& v) {
        string res = "";
        for (int i = 0; i < v.size(); i ++) {
            res += to_string(v[i]) + ";";
        }
        return res;
    }
    
    void fetchAllResults(vector<int>& nums, vector<int>& cur_res, vector<vector<int>>& final_res, int this_idx) {
        string hash_str = convertToString(cur_res);
        if (!inserted[hash_str]) {
            final_res.push_back(cur_res);
            inserted[hash_str] = true;
        }
        if (this_idx >= nums.size()) {
            return;
        }
        cur_res.push_back(nums[this_idx]);
        fetchAllResults(nums, cur_res, final_res, this_idx + 1);
        cur_res.pop_back();
        fetchAllResults(nums, cur_res, final_res, this_idx + 1);
    }
        
};
